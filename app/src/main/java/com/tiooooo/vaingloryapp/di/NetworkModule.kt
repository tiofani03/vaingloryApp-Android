package com.tiooooo.vaingloryapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tiooooo.vaingloryapp.data.implementation.local.AppDatabase
import com.tiooooo.vaingloryapp.data.implementation.remote.api.HeroApi
import com.tiooooo.vaingloryapp.data.implementation.remote.dataSource.HeroRemoteDataSourceImpl
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroRemoteDataSource
import com.tiooooo.vaingloryapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(createChuckerInterceptor(context))
            .readTimeout(15, TimeUnit.SECONDS).connectTimeout(15, TimeUnit.SECONDS).build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofitInstance(@ApplicationContext context: Context): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl(Constants.BASE_URl).client(provideHttpClient(context))
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
    }

    private fun createChuckerInterceptor(context: Context): ChuckerInterceptor {
        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )
        return ChuckerInterceptor.Builder(context = context).collector(chuckerCollector)
            .maxContentLength(250_000L).redactHeaders("Auth-Token", "Bearer").build()
    }

    @Provides
    @Singleton
    fun provideHeroApi(retrofit: Retrofit): HeroApi {
        return retrofit.create(HeroApi::class.java)
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideHeroRemoteDataSource(
        heroApi: HeroApi,
        appDatabase: AppDatabase,
    ): HeroRemoteDataSource {
        return HeroRemoteDataSourceImpl(
            heroApi = heroApi,
            appDatabase = appDatabase,
        )
    }
}

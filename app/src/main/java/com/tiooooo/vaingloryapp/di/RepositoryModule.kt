package com.tiooooo.vaingloryapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.tiooooo.vaingloryapp.data.implementation.repository.HeroRepositoryImpl
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroLocalDataSource
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroRemoteDataSource
import com.tiooooo.vaingloryapp.data.api.repository.DataStoreRepository
import com.tiooooo.vaingloryapp.data.api.repository.HeroRepository
import com.tiooooo.vaingloryapp.data.implementation.repository.DataStoreRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
@OptIn(ExperimentalPagingApi::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(
        remoteDataSource: HeroRemoteDataSource,
        localDataSource: HeroLocalDataSource,
    ): HeroRepository {
        return HeroRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource,
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreOperation(
        @ApplicationContext context: Context,
    ): DataStoreRepository {
        return DataStoreRepositoryImpl(context = context)
    }
}

package com.tiooooo.vaingloryapp.di

import android.content.Context
import androidx.room.Room
import com.tiooooo.vaingloryapp.data.implementation.local.AppDatabase
import com.tiooooo.vaingloryapp.data.implementation.local.dataSource.HeroLocalDataSourceImpl
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroLocalDataSource
import com.tiooooo.vaingloryapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context, AppDatabase::class.java, Constants.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideHeroLocalDataSource(
        database: AppDatabase,
    ): HeroLocalDataSource {
        return HeroLocalDataSourceImpl(
            appDatabase = database,
        )
    }
}

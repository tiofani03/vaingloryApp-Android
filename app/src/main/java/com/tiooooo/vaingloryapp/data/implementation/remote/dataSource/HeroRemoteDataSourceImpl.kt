package com.tiooooo.vaingloryapp.data.implementation.remote.dataSource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tiooooo.vaingloryapp.data.implementation.local.AppDatabase
import com.tiooooo.vaingloryapp.data.pagingSource.HeroRemoteMediator
import com.tiooooo.vaingloryapp.data.implementation.remote.api.HeroApi
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroRemoteDataSource
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.data.pagingSource.SearchHeroesSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class HeroRemoteDataSourceImpl @Inject constructor(
    private val heroApi: HeroApi,
    private val appDatabase: AppDatabase,
) : HeroRemoteDataSource {

    private val heroDao = appDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = 4),
            remoteMediator = HeroRemoteMediator(
                heroApi = heroApi,
                appDatabase = appDatabase,
            ),
            pagingSourceFactory = pagingSourceFactory,
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            pagingSourceFactory = {
                SearchHeroesSource(heroApi, query)
            }
        ).flow
    }

}

package com.tiooooo.vaingloryapp.data.implementation.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroLocalDataSource
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroRemoteDataSource
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.data.api.repository.HeroRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class HeroRepositoryImpl
@Inject constructor(
    private val remoteDataSource: HeroRemoteDataSource,
    private val localDataSource: HeroLocalDataSource,
) : HeroRepository {

    override fun getAllHeroes() = remoteDataSource.getAllHeroes()

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remoteDataSource.searchHeroes(query)
    }

    override suspend fun getDetailHero(heroId: Int) = localDataSource.getSelectedHero(heroId)
    override suspend fun getDetailHeroRemote(heroId: Int) = remoteDataSource.getDetailHero(heroId)
}

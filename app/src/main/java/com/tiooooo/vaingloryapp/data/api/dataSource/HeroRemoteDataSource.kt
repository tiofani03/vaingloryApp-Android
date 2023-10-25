package com.tiooooo.vaingloryapp.data.api.dataSource

import androidx.paging.PagingData
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.utils.response.States
import kotlinx.coroutines.flow.Flow

interface HeroRemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
    fun getDetailHero(heroId: Int): Flow<States<Hero?>>
}

package com.tiooooo.vaingloryapp.data.api.repository

import androidx.paging.PagingData
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.utils.response.States
import kotlinx.coroutines.flow.Flow

interface HeroRepository {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
    suspend fun getDetailHero(heroId: Int): Hero
    suspend fun getDetailHeroRemote(heroId: Int): Flow<States<Hero?>>
}

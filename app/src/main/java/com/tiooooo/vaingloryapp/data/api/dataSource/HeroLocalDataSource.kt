package com.tiooooo.vaingloryapp.data.api.dataSource

import com.tiooooo.vaingloryapp.data.model.Hero

interface HeroLocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}

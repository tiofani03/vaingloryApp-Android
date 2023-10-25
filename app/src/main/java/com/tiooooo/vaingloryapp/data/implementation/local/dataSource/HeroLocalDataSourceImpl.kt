package com.tiooooo.vaingloryapp.data.implementation.local.dataSource

import com.tiooooo.vaingloryapp.data.implementation.local.AppDatabase
import com.tiooooo.vaingloryapp.data.api.dataSource.HeroLocalDataSource

class HeroLocalDataSourceImpl(
    appDatabase: AppDatabase,
) : HeroLocalDataSource {
    private val heroDao = appDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int) = heroDao.getSelectedHero(heroId)
}

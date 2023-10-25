package com.tiooooo.vaingloryapp.data.implementation.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tiooooo.vaingloryapp.data.implementation.local.dao.HeroDao
import com.tiooooo.vaingloryapp.data.implementation.local.dao.HeroRemoteKeysDao
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.data.model.HeroRemoteKeys
import com.tiooooo.vaingloryapp.utils.helper.DatabaseConverter

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao

}

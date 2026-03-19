package com.prueba.tecnica.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prueba.tecnica.core.database.dao.MatchItemDao
import com.prueba.tecnica.core.database.room.MatchItemDB


@Database(entities = [MatchItemDB::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun matchItemDao(): MatchItemDao
}
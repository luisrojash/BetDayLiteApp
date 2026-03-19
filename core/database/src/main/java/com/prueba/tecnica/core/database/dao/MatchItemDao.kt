package com.prueba.tecnica.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prueba.tecnica.core.database.room.MatchItemDB


@Dao
interface MatchItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<MatchItemDB>)

    @Query("SELECT * FROM match_item")
    suspend fun getAll(): List<MatchItemDB>
}
package com.prueba.tecnica.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prueba.tecnica.core.database.room.BetItemDB
import com.prueba.tecnica.core.database.simulation.BetWithMatchDB


@Dao
interface BetItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<BetItemDB>)

    // m.leagueName AS sportLeague,
    @Query("""
       SELECT 
        b.id AS id,
        b.matchId AS matchId,
        (m.homeName || ' vs ' || m.awayName) AS matches,
        b.playedText AS playedText,
        b.oddText AS oddText,
        b.amountLabel AS amountLabel,
        b.amountValue AS amountValue,
        b.status AS status
    FROM bet_item b
    INNER JOIN match_item m
        ON b.matchId = m.id
    GROUP BY b.matchId
    ORDER BY b.id ASC
    """)
    suspend fun getAll(): List<BetWithMatchDB>
}
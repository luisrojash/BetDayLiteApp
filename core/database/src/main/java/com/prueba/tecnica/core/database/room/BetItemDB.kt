package com.prueba.tecnica.core.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "bet_item")
data class BetItemDB(
    @PrimaryKey(autoGenerate = true) val idLocal: Int = 0,
    val id: String,
    val matchId: String,
    val playedText: String,
    val oddText: String,
    val amountLabel: String,
    val amountValue: String,
    val status: String
)

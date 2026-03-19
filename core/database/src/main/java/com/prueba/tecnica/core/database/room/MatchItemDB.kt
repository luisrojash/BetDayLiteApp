package com.prueba.tecnica.core.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "match_item")
data class MatchItemDB(
    @PrimaryKey(autoGenerate = true) val idLocal: Int = 0,
    val id: String,
    val homeName: String,
    val homeShortName: String,
    val awayName: String,
    val awayShortName: String,
    val homeOdd: Double = 0.0,
    val drawOdd: Double = 0.0,
    val awayOdd: Double = 0.0,
    val startTime:String
)
package com.prueba.tecnica.core.database.simulation

data class BetWithMatchDB(
    val id: String,
    val matchId: String,
    val playedText: String,
    val oddText: String,
    val amountLabel: String,
    val amountValue: String,
    val status: String
)
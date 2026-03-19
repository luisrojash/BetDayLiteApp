package com.prueba.tecnica.feature.domain.entities

data class BetListUi(
    val bets: List<BetUi>
)
data class BetUi(
    val id: String,
    val matchId: String,
    val sportLeague: String,
    val match: String,
    val playedText: String,
    val oddText: String,
    val amountLabel: String,
    val amountValue: String,
    val status: BetStatus
)
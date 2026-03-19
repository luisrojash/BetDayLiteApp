package com.prueba.tecnica.features.home.domain.entities

data class MatchesUi(
    val listMatch: List<ItemMatch>
)

data class ItemMatch(
    val id: String = "",
    val startTime: String= "",
    val firstTeam: FirstTeam,
    val secondTeam: SecondTeam,
    val market: Market,
    val status: MatchesStageStatus? = null
)

data class FirstTeam(
    val id: String ,
    val name: String,
    val shortName: String
)

data class SecondTeam(
    val id: String,
    val name: String,
    val shortName: String
)

data class Market(
    val type: String = "",
    val bets: Bets
)

data class Bets(
    val firstBets: Double,
    val secondBets: Double,
    val threeBets: Double
)
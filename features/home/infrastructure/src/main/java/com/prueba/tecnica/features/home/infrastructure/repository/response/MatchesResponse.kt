package com.prueba.tecnica.features.home.infrastructure.repository.response

import com.google.gson.annotations.SerializedName
import com.prueba.tecnica.features.home.domain.entities.Bets
import com.prueba.tecnica.features.home.domain.entities.FirstTeam
import com.prueba.tecnica.features.home.domain.entities.ItemMatch
import com.prueba.tecnica.features.home.domain.entities.Market
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.entities.SecondTeam


data class MatchesResponse(
    @SerializedName("matches")
    val matches: List<MatchesDataResponse> = listOf()
)



data class MatchesDataResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("startTime")
    val startTime: String? = null,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeamResponse,
    @SerializedName("awayTeam")
    val awayTeam: AwayTeamResponse,
    @SerializedName("market")
    val market: MarketResponse
)

data class HomeTeamResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null
)

data class AwayTeamResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null
)
data class MarketResponse(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("odds")
    val bets: BetsResponse
)

data class BetsResponse(
    @SerializedName("home")
    val firstBets: Double = 0.0,
    @SerializedName("draw")
    val secondBets: Double = 0.0,
    @SerializedName("away")
    val threeBets: Double = 0.0
)


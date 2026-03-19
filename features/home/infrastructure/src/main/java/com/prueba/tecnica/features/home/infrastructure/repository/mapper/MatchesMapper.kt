package com.prueba.tecnica.features.home.infrastructure.repository.mapper

import com.prueba.tecnica.features.home.domain.entities.Bets
import com.prueba.tecnica.features.home.domain.entities.FirstTeam
import com.prueba.tecnica.features.home.domain.entities.ItemMatch
import com.prueba.tecnica.features.home.domain.entities.Market
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.entities.SecondTeam
import com.prueba.tecnica.features.home.infrastructure.repository.response.AwayTeamResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.BetsResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.HomeTeamResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MarketResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MatchesDataResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MatchesResponse
import kotlin.collections.map


fun MatchesResponse.toUi(): MatchesUi {
    return MatchesUi(
        listMatch = matches.map { it.toUi() }
    )
}
fun MatchesDataResponse.toUi(): ItemMatch {
    return ItemMatch(
        id = id.orEmpty(),
        startTime = startTime.orEmpty(),
        firstTeam = homeTeam.toUi(),
        secondTeam = awayTeam.toUi(),
        market = market.toUi()
    )
}

fun HomeTeamResponse.toUi(): FirstTeam {
    return FirstTeam(
        id = id.orEmpty(),
        name = name.orEmpty(),
        shortName = shortName.orEmpty()
    )
}

fun AwayTeamResponse.toUi(): SecondTeam {
    return SecondTeam(
        id = id.orEmpty(),
        name = name.orEmpty(),
        shortName = shortName.orEmpty()
    )
}

fun MarketResponse.toUi(): Market {
    return Market(
        type = type.orEmpty(),
        bets = bets.toUi()
    )
}

fun BetsResponse.toUi(): Bets {
    return Bets(
        firstBets = firstBets,
        secondBets = secondBets,
        threeBets = threeBets
    )
}
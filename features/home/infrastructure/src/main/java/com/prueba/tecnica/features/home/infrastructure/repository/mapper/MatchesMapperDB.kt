package com.prueba.tecnica.features.home.infrastructure.repository.mapper

import com.prueba.tecnica.core.database.room.MatchItemDB
import com.prueba.tecnica.features.home.domain.entities.Bets
import com.prueba.tecnica.features.home.domain.entities.FirstTeam
import com.prueba.tecnica.features.home.domain.entities.ItemMatch
import com.prueba.tecnica.features.home.domain.entities.Market
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.domain.entities.SecondTeam


fun ItemMatch.toDomainDB(item: ItemMatch) = MatchItemDB(
    id = id,
    homeName = item.firstTeam.name,
    awayName = item.secondTeam.name,
    homeOdd = item.market.bets.firstBets,
    drawOdd = item.market.bets.threeBets,
    awayOdd = item.market.bets.secondBets,
    homeShortName = item.firstTeam.shortName,
    awayShortName = item.secondTeam.shortName,
    startTime = item.startTime
)

fun MatchItemDB.toDomainUi(itemDB:MatchItemDB) = ItemMatch(
    id = itemDB.id,
    startTime = itemDB.startTime,
    firstTeam = FirstTeam(
        id = itemDB.homeName,
        name = itemDB.homeName,
        shortName = itemDB.homeShortName
    ),
    secondTeam = SecondTeam(
        id = itemDB.awayName,
        name = itemDB.awayName,
        shortName = itemDB.awayShortName
    ),
    market = Market(
        bets = Bets(
            firstBets = itemDB.homeOdd,
            secondBets = itemDB.awayOdd,
            threeBets = itemDB.drawOdd
        )
    )

)
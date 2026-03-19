package com.prueba.tecnica.features.infrastructure.repository.mapper

import com.prueba.tecnica.core.database.room.BetItemDB
import com.prueba.tecnica.core.database.simulation.BetWithMatchDB
import com.prueba.tecnica.feature.domain.entities.BetUi

fun BetWithMatchDB.toUi() = BetUi(
    id = id,
    matchId = matchId,
    sportLeague = "",
    match = "",
    playedText = playedText,
    oddText = oddText,
    amountLabel = amountLabel,
    amountValue = amountValue,
    status = status.toBetStatus()
)
fun BetUi.toDomainDB() = BetItemDB(
    id = id,
    matchId = matchId,
    playedText = playedText,
    oddText = oddText,
    amountLabel = amountLabel,
    amountValue = amountValue,
    status = status.name
)

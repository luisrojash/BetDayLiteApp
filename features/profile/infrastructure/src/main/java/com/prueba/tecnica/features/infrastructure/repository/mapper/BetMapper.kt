package com.prueba.tecnica.features.infrastructure.repository.mapper

import com.prueba.tecnica.feature.domain.entities.BetListUi
import com.prueba.tecnica.feature.domain.entities.BetStatus
import com.prueba.tecnica.feature.domain.entities.BetUi
import com.prueba.tecnica.features.infrastructure.repository.response.BetItemResponse
import com.prueba.tecnica.features.infrastructure.repository.response.BetResponse
import kotlin.collections.map


fun BetResponse.toUi(): BetListUi {
    return BetListUi(
        bets = bets.map { it.toUi() }
    )
}

fun BetItemResponse.toUi(): BetUi {
    val uiStatus = status.toBetStatus()

    return BetUi(
        id = id.orEmpty(),
        matchId = matchId.orEmpty(),
        sportLeague = "",
        match = "",
        playedText = pick.toPlayedText(),
        oddText = odd.toOddText(),
        amountLabel = uiStatus.toAmountLabel(),
        amountValue = stake.toString(),
        status = uiStatus
    )
}



fun Double?.toOddText(): String {
    return "Cuota: ${String.format("%.2f", this ?: 0.0)}"
}

fun BetStatus.toAmountLabel(): String {
    return when (this) {
        BetStatus.PENDING -> "Posible Ganancia"
        BetStatus.WON -> "Ganancia Cobrada"
        BetStatus.LOST -> "Apuesta"
    }
}

fun String?.toPlayedText(): String {
    return when (this?.uppercase()) {
        "HOME" -> "Apostaste a: Victoria Local"
        "AWAY" -> "Apostaste a: Victoria Visitante"
        "DRAW" -> "Apostaste a: Empate"
        else -> "Apostaste a: No disponible"
    }
}

fun String?.toBetStatus(): BetStatus {
    return when (this?.uppercase()) {
        "PENDING" -> BetStatus.PENDING
        "WON" -> BetStatus.WON
        "LOST" -> BetStatus.LOST
        else -> BetStatus.PENDING
    }
}
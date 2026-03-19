package com.prueba.tecnica.features.infrastructure.repository.response

import com.google.gson.annotations.SerializedName



data class BetResponse(
    @SerializedName("bets")
    var bets: List<BetItemResponse> = listOf()
)


data class BetItemResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("matchId")
    val matchId: String? = null,
    @SerializedName("placedAt")
    val placedAt: String? = null,
    @SerializedName("pick")
    val pick: String,
    @SerializedName("odd")
    val odd: Double = 0.0,
    @SerializedName("stake")
    val stake: Double = 0.0,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("return")
    val returnAmount:  Double = 0.0
)
package com.prueba.tecnica.features.infrastructure.repository

import com.prueba.tecnica.features.infrastructure.repository.response.BetResponse
import retrofit2.Response
import retrofit2.http.GET



interface BetService {
    @GET("bets")
    suspend fun getAllBets(
    ): Response<BetResponse>
}
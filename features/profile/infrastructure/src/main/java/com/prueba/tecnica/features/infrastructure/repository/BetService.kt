package com.prueba.tecnica.features.infrastructure.repository

import com.prueba.tecnica.features.infrastructure.repository.response.BetResponse
import retrofit2.Response
import retrofit2.http.GET



interface BetService {
    @GET("625c896b-e9cc-4c81-91cd-4b430370e2ee")
    suspend fun getAllBets(
    ): Response<BetResponse>
}
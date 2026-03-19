package com.prueba.tecnica.features.home.infrastructure.repository

import com.prueba.tecnica.features.home.infrastructure.repository.response.MatchesResponse
import retrofit2.Response
import retrofit2.http.GET


interface MatchesService {
    @GET("matches")
    suspend fun getAllMatches(
    ): Response<MatchesResponse>
}
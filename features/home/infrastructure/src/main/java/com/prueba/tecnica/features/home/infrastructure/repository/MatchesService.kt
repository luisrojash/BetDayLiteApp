package com.prueba.tecnica.features.home.infrastructure.repository

import com.prueba.tecnica.core.networking.remote.ErrorResponse
import com.prueba.tecnica.features.home.infrastructure.repository.response.MatchesResponse
import retrofit2.Response
import retrofit2.http.GET


interface MatchesService {
    @GET("b9fb1498-3fe7-479b-9ba9-1f26f2d8ad60")
    suspend fun getAllMatches(
    ): Response<MatchesResponse>
}
package com.prueba.tecnica.features.home.infrastructure.repository.remote

import com.prueba.tecnica.core.networking.util.executeApiService
import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.features.home.infrastructure.repository.MatchesService

import javax.inject.Inject
import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.features.home.infrastructure.repository.mapper.toUi



class MatchesDataSourceImpl @Inject constructor(private val apiService: MatchesService) :
    MatchesDataSource {


    override suspend fun getListMatches(): Result<MatchesUi> {
        return executeApiService(
            api = { apiService.getAllMatches() },
            transformInfrastructureToDomain = { response ->
                response.toUi()
            }
        )
    }
}
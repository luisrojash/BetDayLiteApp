package com.prueba.tecnica.features.infrastructure.repository.remote

import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.core.networking.util.executeApiService
import com.prueba.tecnica.feature.domain.entities.BetListUi
import com.prueba.tecnica.features.infrastructure.repository.BetService
import com.prueba.tecnica.features.infrastructure.repository.mapper.toUi
import javax.inject.Inject



class BetDataSourceImpl @Inject constructor(private val apiService: BetService) :
    BetDataSource {

    override suspend fun getListBet(): Result<BetListUi> {
        return executeApiService(
            api = { apiService.getAllBets() },
            transformInfrastructureToDomain = { response ->
                response.toUi()
            }
        )
    }
}
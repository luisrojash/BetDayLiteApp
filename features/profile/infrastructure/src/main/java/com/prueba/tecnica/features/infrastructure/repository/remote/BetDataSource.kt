package com.prueba.tecnica.features.infrastructure.repository.remote

import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.feature.domain.entities.BetListUi


interface BetDataSource {
    suspend fun getListBet(): Result<BetListUi>
}
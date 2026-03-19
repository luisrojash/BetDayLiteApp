package com.prueba.tecnica.feature.domain.repository

import com.prueba.tecnica.core.domain.Result
import com.prueba.tecnica.feature.domain.entities.BetListUi


interface BetRepository {
    suspend fun getListBets(): Result<BetListUi>
}
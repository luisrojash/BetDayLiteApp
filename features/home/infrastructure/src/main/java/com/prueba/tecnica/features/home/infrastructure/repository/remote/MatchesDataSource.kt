package com.prueba.tecnica.features.home.infrastructure.repository.remote

import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.core.domain.Result
interface MatchesDataSource {
    suspend fun getListMatches(): Result<MatchesUi>
}
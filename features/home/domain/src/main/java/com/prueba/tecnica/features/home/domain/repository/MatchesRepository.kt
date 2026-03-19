package com.prueba.tecnica.features.home.domain.repository

import com.prueba.tecnica.features.home.domain.entities.MatchesUi
import com.prueba.tecnica.core.domain.Result

interface MatchesRepository {
    suspend fun getListMatches(): Result<MatchesUi>
}
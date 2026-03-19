package com.prueba.tecnica.features.home.domain.usecase

import com.prueba.tecnica.features.home.domain.repository.MatchesRepository
import javax.inject.Inject


class MatchesUseCase@Inject constructor(private val repository: MatchesRepository) {
    suspend operator fun invoke() = repository.getListMatches()
}
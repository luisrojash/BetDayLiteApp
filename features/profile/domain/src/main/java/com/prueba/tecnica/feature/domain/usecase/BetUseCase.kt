package com.prueba.tecnica.feature.domain.usecase

import com.prueba.tecnica.feature.domain.repository.BetRepository
import javax.inject.Inject

class BetUseCase@Inject constructor(private val repository: BetRepository) {
    suspend operator fun invoke() = repository.getListBets()
}
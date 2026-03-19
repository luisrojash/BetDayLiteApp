package com.prueba.tecnica.features.presentation

import com.prueba.tecnica.core.common.presentation.ErrorState
import com.prueba.tecnica.feature.domain.entities.BetUi



data class ProfileState(
    var errorState: ErrorState = ErrorState.None,
    val showConnectivity: Boolean = false,
    var showLoadingContent: Boolean = false,
    val listBets: List<BetUi> = listOf()
)
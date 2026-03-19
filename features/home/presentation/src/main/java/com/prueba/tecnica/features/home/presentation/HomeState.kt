package com.prueba.tecnica.features.home.presentation

import com.prueba.tecnica.core.common.presentation.ErrorState
import com.prueba.tecnica.features.home.domain.entities.ItemMatch

data class HomeState(
    var errorState: ErrorState = ErrorState.None,
    val showConnectivity: Boolean = false,
    var showLoadingContent: Boolean = false,
    val listMatches: List<ItemMatch> = listOf()
)
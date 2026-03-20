package com.prueba.tecnica.features.presentation

import com.prueba.tecnica.feature.domain.entities.BetUi

sealed interface ProfileIntent {

    class OnClickedCardProfile(var betUi: BetUi) : ProfileIntent
}
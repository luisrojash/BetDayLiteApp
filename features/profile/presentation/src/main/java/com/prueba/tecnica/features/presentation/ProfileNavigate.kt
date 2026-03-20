package com.prueba.tecnica.features.presentation


sealed interface ProfileNavigate {
    data object OnBackPressed : ProfileNavigate
    class NavigateDetailsBets(
        val leagueName: String,
        val date: String,
        val firstTeam: String,
        val secondTeam: String,
        val share: String,
        val  speak: String
    ) : ProfileNavigate
}
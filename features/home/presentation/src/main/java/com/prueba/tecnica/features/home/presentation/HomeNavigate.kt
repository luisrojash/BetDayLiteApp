package com.prueba.tecnica.features.home.presentation


sealed interface HomeNavigate {
    data object OnBackPressed : HomeNavigate
}
package com.prueba.tecnica.features.presentation



sealed interface ProfileNavigate {
    data object OnBackPressed : ProfileNavigate
}
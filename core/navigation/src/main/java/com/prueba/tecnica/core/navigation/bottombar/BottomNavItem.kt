package com.prueba.tecnica.core.navigation.bottombar

sealed class BottomNavItem(val route: String) {
    object Home : BottomNavItem("home")
    object Profile : BottomNavItem("profile")
}
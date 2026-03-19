package com.prueba.tecnica.core.navigation



sealed class BottomNavItem(val route: String) {
    object Home : BottomNavItem("home")
    object Profile : BottomNavItem("profile")
}
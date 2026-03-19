package com.prueba.tecnica.core.navigation.bottombar


import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavUiItem(
    val route: String,
    val label: String,
    //val icon: ImageVector
)

fun BottomNavItem.toUi(): BottomNavUiItem {
    return when (this) {
        BottomNavItem.Home -> BottomNavUiItem(
            route = route,
            label = "Home",
            //icon = Icons.Default.Home
        )
        BottomNavItem.Profile -> BottomNavUiItem(
            route = route,
            label = "Profile",
          //  icon = Icons.Default.Person
        )
    }
}
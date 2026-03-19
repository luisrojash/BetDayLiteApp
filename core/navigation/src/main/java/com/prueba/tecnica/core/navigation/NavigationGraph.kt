package com.prueba.tecnica.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prueba.tecnica.core.navigation.bottombar.BottomNavItem
import com.prueba.tecnica.features.home.presentation.HomeScreen
import com.prueba.tecnica.features.presentation.ProfileScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    padding: PaddingValues = PaddingValues()
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }

        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
    }
}
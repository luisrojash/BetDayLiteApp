package com.prueba.tecnica.lerp

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prueba.tecnica.core.designsystem.theme.Green500
import com.prueba.tecnica.core.designsystem.theme.Primary
import com.prueba.tecnica.core.navigation.NavigationGraph
import com.prueba.tecnica.core.navigation.bottombar.BottomNavItem
import com.prueba.tecnica.core.navigation.bottombar.toUi


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile
    ).map { it.toUi() }

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    Log.i("MainScreen", "MainScreen: $currentRoute")
    Scaffold(
        bottomBar = {
            if(currentRoute != "/register_screen_details_bets"){
                NavigationBar (
                    containerColor = Primary
                ){

                    items.forEach { item ->
                        NavigationBarItem(
                            selected = currentRoute == item.route,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(BottomNavItem.Home.route) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (item.label == "Home") Icons.Default.Home else Icons.Default.Person,
                                    contentDescription = item.label
                                )
                            },
                            label = {
                                Text(text = item.label)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Black,
                                selectedTextColor = Green500,
                                unselectedIconColor = Color.Gray,
                                unselectedTextColor = Color.Gray,
                                indicatorColor = Green500
                            )
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavigationGraph(
            navController = navController,
            padding = padding
        )
    }
}
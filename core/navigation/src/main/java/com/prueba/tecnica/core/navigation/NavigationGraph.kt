package com.prueba.tecnica.core.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.prueba.tecnica.core.navigation.bottombar.BottomNavItem
import com.prueba.tecnica.features.detailbets.presentation.BetDetailScreen
import com.prueba.tecnica.features.detailbets.presentation.routes.DetailsBetsRoutes
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
            ProfileScreen(
                onNavigateDetailBets = { leagueName,
                                         date,
                                         firstTeam,
                                         secondTeam,
                                         share,
                                         speak ->
                    navController.navigate(
                        DetailsBetsRoutes.RegistrationScreenDetails
                            .createRoute(
                                leagueName = leagueName,
                                date = date,
                                firstTeam = firstTeam,
                                secondTeam = secondTeam,
                                share = share,
                                speak = speak
                            )
                    )
                }
            )
        }
        composable(
            DetailsBetsRoutes.RegistrationScreenDetails.route,
            arguments = listOf(
                navArgument("leagueName") { type = NavType.StringType },
                navArgument("date") { type = NavType.StringType },
                navArgument("firstTeam") { type = NavType.StringType },
                navArgument("secondTeam") { type = NavType.StringType },
                navArgument("share") { type = NavType.StringType },
                navArgument("speak") { type = NavType.StringType }
            )) { backStackEntry ->

            val leagueName = backStackEntry.arguments?.getString("leagueName").orEmpty()
            val date = backStackEntry.arguments?.getString("date").orEmpty()
            val firstTeam = backStackEntry.arguments?.getString("firstTeam").orEmpty()
            val secondTeam = backStackEntry.arguments?.getString("secondTeam").orEmpty()
            val share = backStackEntry.arguments?.getString("share").orEmpty()
            val speak = backStackEntry.arguments?.getString("speak").orEmpty()

            BetDetailScreen(
                leagueName = leagueName,
                date = date,
                firstTeam = firstTeam,
                secondTeam = secondTeam,
                share = share,
                speak = speak,
                onClickedBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}
package com.prueba.tecnica.features.detailbets.presentation.routes


const val REGISTER_SCREEN_DETAILS_BETS =
    "register_screen_details_bets/{leagueName}/{date}/{firstTeam}/{secondTeam}/{share}/{speak}"

sealed class DetailsBetsRoutes(val route: String) {
    data object RegistrationScreenDetails :
        DetailsBetsRoutes(REGISTER_SCREEN_DETAILS_BETS)

    fun createRoute(
        leagueName: String,
        date: String,
        firstTeam: String,
        secondTeam: String,
        share: String,
        speak: String
    ): String {
        return "register_screen_details_bets/$leagueName/$date/$firstTeam/$secondTeam/$share/$speak"
    }
}
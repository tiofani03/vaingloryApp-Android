package com.tiooooo.vaingloryapp.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splashScreen")
    object Welcome : Screen("welcomeScreen")
    object Home : Screen("homeScreen")
    object Detail : Screen("detailScreen/{heroId}") {
        fun passHeroId(heroId: Int): String {
            return "detailScreen/$heroId"
        }
    }

    object Search : Screen("searchScreen")
}

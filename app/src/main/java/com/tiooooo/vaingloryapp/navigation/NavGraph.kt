package com.tiooooo.vaingloryapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tiooooo.vaingloryapp.presentation.screen.detail.DetailScreen
import com.tiooooo.vaingloryapp.presentation.screen.home.HomeScreen
import com.tiooooo.vaingloryapp.presentation.screen.search.SearchScreen
import com.tiooooo.vaingloryapp.presentation.screen.splash.SplashScreen
import com.tiooooo.vaingloryapp.utils.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    val modifier = Modifier
        .background(MaterialTheme.colorScheme.surface)
        .navigationBarsPadding()
        .statusBarsPadding()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(
                modifier = modifier,
                navController = navController,
            )
        }

        composable(route = Screen.Search.route) {
            SearchScreen(
                modifier = modifier,
                navController = navController,
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) { type = NavType.IntType })
        ){
            DetailScreen(
                modifier = modifier,
                navController = navController
            )
        }
    }
}

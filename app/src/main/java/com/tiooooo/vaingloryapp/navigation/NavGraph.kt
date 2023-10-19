package com.tiooooo.vaingloryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tiooooo.vaingloryapp.presentation.screen.splash.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
    ){
        composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }
    }
}

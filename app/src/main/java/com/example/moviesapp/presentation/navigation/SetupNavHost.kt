package com.example.moviesapp.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moviesapp.presentation.MainViewModel
import com.example.moviesapp.presentation.screens.MainScreen
import com.example.moviesapp.presentation.screens.SplashScreen
import com.example.moviesapp.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel

sealed class Screens(val route: String){
    object Splash: Screens(route = Constants.Screens.SPLASH_SCREEN)
    object Main: Screens(route = Constants.Screens.MAIN_SCREEN)
    object Details: Screens(route = Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel){
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route,
        modifier = Modifier.background(MaterialTheme.colors.background)
    ){
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Details.route) {

        }
    }

}
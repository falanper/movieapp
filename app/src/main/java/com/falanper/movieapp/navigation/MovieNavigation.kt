package com.falanper.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.falanper.movieapp.screens.details.DetailsScreen
import com.falanper.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    // Navigation Controller
    val navController = rememberNavController()

    // Navigation Host
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {

        // Navigation Graph Builder
        composable(MovieScreens.HomeScreen.name) {
            // Here we pass where this lead us to
            HomeScreen(navController = navController)
        }

        // www.google.com/detail-screen/id=34
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(
                navArgument(name = "movie") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}
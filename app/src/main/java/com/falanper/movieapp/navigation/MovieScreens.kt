package com.falanper.movieapp.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen,
    HarryPoterScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            HarryPoterScreen.name -> HarryPoterScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route you tried to access is not recognized.")
        }
    }
}
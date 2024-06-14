package com.example.advance_jetpack_compost.movieList.util

sealed class Screen(val route: String) {
    object Home : Screen("main")
    object Login : Screen("login")
    object Profile : Screen("Profile")
    object PopularMovieList : Screen("popularMovie")
    object UpcomingMovieList : Screen("upcomingMovie")
    object Details : Screen("details")
    object Maps : Screen("maps")
}
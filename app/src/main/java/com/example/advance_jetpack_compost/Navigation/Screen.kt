package com.example.advance_jetpack_compost.Navigation

sealed class Screen (val route : String) {
    data object Login : Screen("login")
}
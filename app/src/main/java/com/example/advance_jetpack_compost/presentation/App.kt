package com.example.advance_jetpack_compost.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.advance_jetpack_compost.Navigation.Screen
import com.example.advance_jetpack_compost.presentation.login.Login

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        //modifier = modifier.padding(contentPadding)
    ) {
        composable(Screen.Login.route) {
            Login(navController)
        }
    }
}
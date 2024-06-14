package com.example.advance_jetpack_compost

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.advance_jetpack_compost.detail.presentation.DetailsScreen
import com.example.advance_jetpack_compost.movieList.presentation.MapsScreen
import com.example.advance_jetpack_compost.movieList.util.Screen
import com.example.advance_jetpack_compost.presentation.login.Login
import com.example.advance_jetpack_compost.presentation.profile.ProfileScreen
import com.example.advance_jetpack_compost.ui.theme.AdvanceJetpackCompostTheme
import com.example.advance_jetpack_compost.ui.theme.ShimmerListItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdvanceJetpackCompostTheme {
                var isLoading by remember {
                    mutableStateOf(true)
                }
                LaunchedEffect(key1 = true) {
                    delay(3000)
                    isLoading = false
                }
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ){
                    items(20){
                        ShimmerListItem(
                            isLoading = isLoading,
                            contentAfterLoading ={


                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
                SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column() {
                        repeat(10) {
                            ShimmerListItem(isLoading = isLoading, contentAfterLoading = {
                                val navController = rememberNavController()

                                NavHost(
                                    navController = navController,
                                    startDestination = Screen.Login.route
                                ) {
                                    composable(Screen.Home.route) {
                                        HomeScreen(navController)
                                    }
                                    composable(Screen.Login.route) {
                                        Login(navController)
                                    }
                                    composable(Screen.Maps.route) {
                                        MapsScreen(navController)
                                    }
                                    composable(Screen.Profile.route) {
                                        ProfileScreen(navController)
                                    }
                                    composable(
                                        Screen.Details.route + "/{movieId}",
                                        arguments = listOf(
                                            navArgument("movieId") { type = NavType.IntType }
                                        )
                                    ) { backStackEntry ->
                                        DetailsScreen()
                                    }
                                }
                            }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SetBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    LaunchedEffect(key1 = color) {
        systemUiController.setSystemBarsColor(color)
    }
}




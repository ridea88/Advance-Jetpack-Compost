package com.example.advance_jetpack_compost.presentation.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.advance_jetpack_compost.data.firebase.DataStore
import com.example.advance_jetpack_compost.data.firebase.SharedPreferencesManager
import com.example.advance_jetpack_compost.movieList.util.Screen
import com.example.advance_jetpack_compost.presentation.profile.component.FooterProfile
import com.example.advance_jetpack_compost.presentation.profile.component.HeaderProfile
import com.example.advance_jetpack_compost.presentation.profile.component.MiddleProfile
import kotlinx.coroutines.launch



@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier = Modifier,

) {


    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()


    val sharedPreferencesManager = remember {
        SharedPreferencesManager(context)
    }
    val dataStore = DataStore(context)

    val email = sharedPreferencesManager.email?: ""


    ProfileContent(
        navController = navController,
        email = email,
        onLogoutClick = {
            sharedPreferencesManager.clear()
            coroutineScope.launch {
                dataStore.clearStatus()
            }
            navController.navigate(Screen.Login.route) {
            }
        },
        onBackClick = {

            coroutineScope.launch {
                sharedPreferencesManager.email = email
                dataStore.saveStatus(true)
            }
            sharedPreferencesManager.clear()
            navController.navigate(Screen.Home.route) {
            }
        },

        modifier = modifier
    )
}

@Composable
fun ProfileContent(
    navController: NavController,
    email: String,
    onLogoutClick : () -> Unit,
    onBackClick : () -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(top = 30.dp)
            .padding(horizontal = 16.dp)
    ) {
        item {
            HeaderProfile(
                email = email,
                onBackClick = onBackClick,
                modifier = Modifier
                    .padding(start = 90.dp),

                )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            MiddleProfile(
                name = email,
                modifier = Modifier
                    .padding(start = 90.dp),

                )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            FooterProfile(
                name = email,
                onLogoutClick = onLogoutClick,
                modifier = Modifier
                    .padding(start = 90.dp)

            )
        }
    }
}
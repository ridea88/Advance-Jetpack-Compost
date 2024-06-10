package com.example.advance_jetpack_compost.presentation.login

import com.google.firebase.auth.AuthResult

data class LoginGoogleState(
    val success: AuthResult? = null,
    val error: String? = "",
    val loading: Boolean = true
)
data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)
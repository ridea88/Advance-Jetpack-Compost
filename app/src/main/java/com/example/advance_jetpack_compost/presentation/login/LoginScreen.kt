package com.example.advance_jetpack_compost.presentation.login

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.advance_jetpack_compost.movieList.util.Screen
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

@Composable
fun Login(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state.collectAsState(initial = null)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }
    val googleLoginState = viewModel.stateGoogle.value


    Box(modifier = Modifier.fillMaxSize()) {
        LoginScreen(
            email = email,
            password = password,
            passwordConfirm = passwordConfirm,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onPasswordConfirmChange = { passwordConfirm = it },
            onLoginClick = {
                coroutineScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Email dan Password Wajib Diisi",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        viewModel.loginUser(email, password) {
                            Toast.makeText(
                                context,
                                "Login Berhasil",
                                Toast.LENGTH_SHORT
                            )
//                                .show()
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Login.route) {
                                    inclusive = true
                                }
                            }
                            email = ""
                            password = ""
                        }
                    }
                }
            },
            onRegisterClick = {
                coroutineScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Email dan Password Wajib Diisi",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (password != passwordConfirm) {
                        Toast.makeText(
                            context,
                            "Password dan Konfirmasi Password tidak cocok",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.registerUser(email, password) {
                            Toast.makeText(
                                context,
                                "Register Berhasil",
                                Toast.LENGTH_SHORT
                            )
                                .show()
//                            navController.navigate(Screen.Home.route) {
//                                popUpTo(Screen.Login.route) { inclusive = true }
//                            }
                            email = ""
                            password = ""
                            passwordConfirm = ""
                        }
                    }
                }
            },

            modifier = modifier,
            navController = navController
        )
        LaunchedEffect(key1 = state.value?.success) {
            coroutineScope.launch {
                if (state.value?.success?.isNotEmpty() == true) {
                    val success = state.value?.success
                    Toast.makeText(context, "$success", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LaunchedEffect(key1 = state.value?.error) {
            coroutineScope.launch {
                if (state.value?.error?.isNotEmpty() == true) {
                    val error = state.value?.error
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LaunchedEffect(key1 = googleLoginState.success) {
            coroutineScope.launch {
                if (googleLoginState.success != null) {
                    Toast.makeText(context, "Login With Google Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
@Composable
fun LoginScreen(
    email: String,
    password: String,
    passwordConfirm: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onLoginClick: () -> Unit,

    onRegisterClick: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier
                        .padding(bottom = 50.dp),
                    text = "Masuk",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    //fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Column (
                    modifier = Modifier
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .size(width = 320.dp, height = 510.dp)
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = onEmailChange,
                        label = {Text(text = "Email address")},
                        leadingIcon = {Icon(imageVector = Icons.Default.Email , contentDescription = null)},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        visualTransformation = VisualTransformation.None,
                        shape = RoundedCornerShape(10.dp)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = onPasswordChange,
                        label = {Text(text = "Password")},
                        leadingIcon = {Icon(imageVector = Icons.Default.Lock , contentDescription = null)},
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Button(
                        onClick = onLoginClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                        ),
                        modifier = Modifier
                            .size(width = 280.dp, height = 40.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Masuk",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                           // fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = onEmailChange,
                        label = { Text(text = "Masukkan Email") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Email , contentDescription = null) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        visualTransformation = VisualTransformation.None,
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(width = 300.dp, height = 65.dp)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = onPasswordChange,
                        label = { Text(text = "Password") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock , contentDescription = null) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(width = 300.dp, height = 65.dp)
                    )
                    OutlinedTextField(
                        value = passwordConfirm,
                        onValueChange = onPasswordConfirmChange,
                        label = { Text(text = "Masukkan Ulang Password") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock , contentDescription = null) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        visualTransformation = PasswordVisualTransformation(),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(width = 300.dp, height = 65.dp)
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Button(
                        onClick = onRegisterClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray
                        ),
                        modifier = Modifier
                            .size(width = 280.dp, height = 40.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Daftar",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            //fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold
                        )
                    }
                }

                Row (
                    modifier = Modifier
                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Belum Punya Akun?",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        //fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Sign Up",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start,
                        //fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .clickable { navController.navigate("register") }
                    )

                }
            }
        }
}

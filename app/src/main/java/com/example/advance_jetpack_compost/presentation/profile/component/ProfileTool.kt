package com.example.advance_jetpack_compost.presentation.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.ArrowLeft
import androidx.compose.material.icons.automirrored.filled.Forward
import androidx.compose.material.icons.automirrored.filled.Logout

import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.advance_jetpack_compost.R




@Composable
fun HeaderProfile(
    email: String,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit

    ) {

    IconButton(
        modifier = Modifier
            .size(60.dp)
            .padding(end = 20.dp)
            .offset(y = 10.dp,)
        ,
        onClick = onBackClick ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = "Logout Icon")
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .offset(x = 10.dp)
    ) {

        Column {


            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(MaterialTheme.colorScheme.primary)) {
                        append(email)
                    }
                },
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )

            Text(text = "Diamon Pass", style = MaterialTheme.typography.bodyLarge)
        }

    }
}




@Composable
fun MiddleProfile(
    name: String,
    modifier: Modifier = Modifier,

) {
    Column(modifier = Modifier
       ) {
        Row(  modifier = Modifier
            .offset( y = 50.dp, x = 20.dp)
            ,){

         Column(
             modifier = Modifier
                 .padding(top = 80.dp,start = 20.dp)
         ) {
             Button(
                 colors = ButtonDefaults.buttonColors(
                     contentColor = Color.White,
                     containerColor = Color.DarkGray,
                 ),
                 modifier = Modifier
                     .width(300.dp)
                 ,
                 onClick = {"m"}) {
                 Text(text = "Pengaturan Akun")
             }
             Spacer(modifier = Modifier.height(8.dp))
             Button(
                 colors = ButtonDefaults.buttonColors(
                     contentColor = Color.White,
                     containerColor = Color.DarkGray,
                 ),
                 modifier = Modifier
                     .width(300.dp),
                 onClick = {"m"}) {
                 Text(text = "Keamanan Privasi")
             }
             Spacer(modifier = Modifier.height(8.dp))
             Button(
                 colors = ButtonDefaults.buttonColors(
                     contentColor = Color.White,
                     containerColor = Color.DarkGray,
                 ),
                 modifier = Modifier
                     .width(300.dp),
                 onClick = {"m"}) {
                 Text(text = "Masalah Terhadap Aplikasi")
             }
             Spacer(modifier = Modifier.height(8.dp))
             Button(
                 colors = ButtonDefaults.buttonColors(
                     contentColor = Color.White,
                     containerColor = Color.DarkGray,
                 ),
                 modifier = Modifier
                     .width(300.dp),
                 onClick = {"m"}) {
                 Text(text = "Kunjungi Web Site Kami")
             }
             Spacer(modifier = Modifier.height(8.dp))
             Button(
                 colors = ButtonDefaults.buttonColors(
                     contentColor = Color.White,
                     containerColor = Color.DarkGray,
                 ),
                 modifier = Modifier
                     .width(300.dp),
                 onClick = {"m"}) {
                 Text(text = "Feedback")
             }

         }
            
            
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.fillMaxWidth()
        ) {

            Column {


            }

        }
    }

}



@Composable
fun FooterProfile(
    name: String,
    modifier: Modifier = Modifier,
    onLogoutClick: () -> Unit
) {
    Column(modifier = Modifier
        .padding(top = 170.dp)) {
        Row(  modifier = Modifier
            .offset( y = -30.dp, x = 40.dp)
            ,){
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                ),
                modifier = Modifier
                    .width(300.dp)
                ,
                onClick =   onLogoutClick ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout, contentDescription = "Logout Icon")
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {

            Column {

                Text(
                    modifier = modifier
                        .offset(x = -35.dp),
                    text = "Copy Right By Ambhilasa Pattimura", style = MaterialTheme.typography.bodyLarge)
            }

        }
    }

}
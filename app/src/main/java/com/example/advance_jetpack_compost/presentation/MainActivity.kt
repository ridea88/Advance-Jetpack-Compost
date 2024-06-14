package com.example.advance_jetpack_compost.presentation
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.compose.rememberNavController
//import com.example.advance_jetpack_compost.presentation.login.Login
//import com.example.advance_jetpack_compost.ui.theme.AdvanceJetpackCompostTheme
//import dagger.hilt.android.AndroidEntryPoint
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.activity.viewModels
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
////import com.example.advance_jetpack_compost.model.Movie
////import com.example.advance_jetpack_compost.ui.theme.AdvanceJetpackCompostTheme
////import com.example.advance_jetpack_compost.view.MovieItem
////import com.example.advance_jetpack_compost.viewModel.MovieViewModel
//
//
//
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//
//    //val movieViewModel by viewModels<MovieViewModel> ()
//    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            AdvanceJetpackCompostTheme {
//                Login(navController = rememberNavController())
//            }
//        }
//    }
//}
//
//
////@Composable
////fun MovieList(movieList:List<Movie>) {
////    LazyColumn {
////        itemsIndexed(items = movieList){index, item ->
////            MovieItem(movie = item)
////        }
////    }
////}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
////@Preview(showBackground = true)
////@Composable
////fun GreetingPreview() {
////    AdvanceJetpackCompostTheme {
////        val movie = Movie("test1","test2","test3","test4")
////        MovieItem(movie = movie)
////    }
////}
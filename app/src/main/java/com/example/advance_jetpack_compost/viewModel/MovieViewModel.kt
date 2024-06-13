package com.example.advance_jetpack_compost.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.advance_jetpack_compost.model.Movie
import com.example.advance_jetpack_compost.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {

    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getMovieList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movielist = apiService.getMovie()
                movieListResponse = movielist
            }
            catch (e :Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}
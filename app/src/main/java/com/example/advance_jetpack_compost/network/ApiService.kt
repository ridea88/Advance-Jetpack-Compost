package com.example.advance_jetpack_compost.network

import com.example.advance_jetpack_compost.model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {
    @GET("movielist.json")
    suspend fun getMovie() : List<Movie>

    companion object{
        var apiService:ApiService? = null
        fun getInstance():ApiService{
            if(apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}
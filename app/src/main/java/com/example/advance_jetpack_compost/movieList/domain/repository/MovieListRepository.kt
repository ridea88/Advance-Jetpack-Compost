package com.example.advance_jetpack_compost.movieList.domain.repository

import com.example.advance_jetpack_compost.movieList.domain.model.Movie
import com.example.advance_jetpack_compost.movieList.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id: Int): Flow<Resource<Movie>>
}
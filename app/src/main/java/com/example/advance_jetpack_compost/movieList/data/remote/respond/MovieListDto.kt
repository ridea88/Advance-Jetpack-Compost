package com.example.advance_jetpack_compost.movieList.data.remote.respond

data class MovieListDto(
    val page: Int,
    val results: List<MovieDto>,
    val total_pages: Int,
    val total_results: Int
)
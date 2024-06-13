package com.example.advance_jetpack_compost.detail.presentation

import com.example.advance_jetpack_compost.movieList.domain.model.Movie


data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)

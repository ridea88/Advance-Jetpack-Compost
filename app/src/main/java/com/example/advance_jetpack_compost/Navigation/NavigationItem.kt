package com.example.advance_jetpack_compost.Navigation

import com.example.advance_jetpack_compost.movieList.util.Screen


data class NavigationItem (
    val title: String,
    val icon: Int,
    val screen: Screen,
    val iconSelected: Int
)
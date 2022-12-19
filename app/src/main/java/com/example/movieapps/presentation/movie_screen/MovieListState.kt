package com.example.movieapps.presentation.movie_screen

import com.example.movieapps.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie>? = null,
    val error: String = ""
)

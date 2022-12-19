package com.example.movieapps.presentation

sealed class Screen (val route:String){
    object MovieListScreen: Screen("movie_list")
    object MovieDetailScreen: Screen("movie_detail")
}

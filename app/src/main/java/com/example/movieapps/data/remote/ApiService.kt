package com.example.movieapps.data.remote

import com.example.movieapps.data.remote.dto.MovieDto
import com.example.movieapps.data.remote.dto.ResultDto
import retrofit2.http.GET

interface ApiService {

    @GET("/now_playing")
    suspend fun getMovies(): List<MovieDto>


}
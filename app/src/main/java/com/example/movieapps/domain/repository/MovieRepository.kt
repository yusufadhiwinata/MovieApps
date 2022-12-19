package com.example.movieapps.domain.repository

import com.example.movieapps.data.remote.dto.MovieDto
import com.example.movieapps.data.remote.dto.ResultDto

interface MovieRepository {
    suspend fun getMovies() :List<MovieDto>
}
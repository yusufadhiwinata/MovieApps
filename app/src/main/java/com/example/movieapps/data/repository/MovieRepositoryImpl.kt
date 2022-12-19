package com.example.movieapps.data.repository

import com.example.movieapps.data.remote.ApiService
import com.example.movieapps.data.remote.dto.MovieDto
import com.example.movieapps.data.remote.dto.ResultDto
import com.example.movieapps.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService : ApiService
):MovieRepository{
    override suspend fun getMovies(): List<MovieDto> {
       return apiService.getMovies()
    }
}
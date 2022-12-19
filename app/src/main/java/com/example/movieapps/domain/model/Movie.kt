package com.example.movieapps.domain.model

import com.example.movieapps.data.remote.dto.Dates
import com.example.movieapps.data.remote.dto.ResultDto
import com.google.gson.annotations.SerializedName

data class Movie(
    val dates: Dates,
    val page: Int,
    val results: List<ResultDto>,
    val totalPages: Int,
    val totalResults: Int
)

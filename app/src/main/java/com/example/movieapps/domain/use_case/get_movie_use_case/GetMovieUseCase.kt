package com.example.movieapps.domain.use_case.get_movie_use_case

import com.example.movieapps.common.Resource
import com.example.movieapps.data.remote.dto.toMovie
import com.example.movieapps.domain.model.Movie
import com.example.movieapps.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovies().map {
                it.toMovie()
            }
            emit(Resource.Success(movie))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server.Check your internet connection"))

        }

    }
}
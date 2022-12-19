package com.example.movieapps.presentation.movie_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapps.common.Resource
import com.example.movieapps.domain.use_case.get_movie_use_case.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state

    init {
        getMovies()
    }

    private fun getMovies() {
        getMovieUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MovieListState(movies = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        MovieListState(error = result.message ?: "An unexpected error occurred")
                }
            }

        }.launchIn(viewModelScope)

    }
}
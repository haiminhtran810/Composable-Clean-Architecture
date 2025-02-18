package com.home.androidComposable.screen.home

import com.home.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class HomeUiState(
    // Movie
    val popularMovies: Flow<List<Movie>> = emptyFlow(),
    val topRatedMovies: Flow<List<Movie>> = emptyFlow(),
    val nowPlayingMovies: Flow<List<Movie>> = emptyFlow(),
    val upcomingMovies: Flow<List<Movie>> = emptyFlow(),
)

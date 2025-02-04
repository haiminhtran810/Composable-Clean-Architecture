package com.home.domain.repository

import com.home.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): Flow<List<Movie>>
    suspend fun getMovieDetail(movieId: String): Flow<Movie>
}
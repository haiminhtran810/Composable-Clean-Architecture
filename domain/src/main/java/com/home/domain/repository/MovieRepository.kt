package com.home.domain.repository

import com.home.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): List<Movie>
    suspend fun getMovieDetail(movieId: String): Movie
}
package com.home.data.service.repository

import com.home.data.service.api.MovieAPI
import com.home.domain.model.movie.Movie
import com.home.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieApi: MovieAPI) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return movieApi.getMovieListPopular(page).results?.toList().orEmpty()
    }

    override suspend fun getMovieDetail(movieId: String): Movie {
        return movieApi.getMovieDetailAsync(movieId)
    }


}
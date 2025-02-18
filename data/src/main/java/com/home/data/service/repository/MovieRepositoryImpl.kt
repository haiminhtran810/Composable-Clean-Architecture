package com.home.data.service.repository

import com.home.data.service.api.MovieAPI
import com.home.domain.model.movie.Movie
import com.home.domain.repository.MovieRepository

class MovieRepositoryImpl(private val movieApi: MovieAPI) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return movieApi.getMovieListPopular(page).results?.toList().orEmpty()
    }

    override suspend fun getTopRatedMovies(page: Int): List<Movie> {
        return movieApi.getMovieListTopRated(page).results?.toList().orEmpty()
    }

    override suspend fun getNowPlayingMovies(page: Int): List<Movie> {
        return movieApi.getMovieListNowPlaying(page).results?.toList().orEmpty()
    }

    override suspend fun getUpcomingMovies(page: Int): List<Movie> {
        return movieApi.getMovieListUpcoming(page).results?.toList().orEmpty()
    }

    override suspend fun getMovieDetail(movieId: String): Movie {
        return movieApi.getMovieDetailAsync(movieId)
    }

}
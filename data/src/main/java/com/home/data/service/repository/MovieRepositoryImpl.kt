package com.home.data.service.repository

import com.home.data.service.api.MovieAPI
import com.home.domain.model.movie.Movie
import com.home.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(private val movieApi: MovieAPI) : MovieRepository {
    override suspend fun getPopularMovies(page: Int): Flow<List<Movie>> {
        return flow {
            val data = movieApi.getMovieListPopular(page).results?.toList().orEmpty()
            emit(data)
        }
    }

    override suspend fun getMovieDetail(movieId: String): Flow<Movie> {
        return flow {
            movieApi.getMovieDetailAsync(movieId)
        }
    }


}
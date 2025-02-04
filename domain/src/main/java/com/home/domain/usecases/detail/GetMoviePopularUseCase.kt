package com.home.domain.usecases.detail

import com.home.domain.model.movie.Movie
import com.home.domain.repository.MovieRepository
import com.home.domain.usecases.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMoviePopularUseCase(
    private val movieRepository: MovieRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<GetMoviePopularUseCase.Params, List<Movie>>(dispatcher) {

    data class Params(val page: Int)

    override fun execute(params: Params?): Flow<List<Movie>> {
        return flow { movieRepository.getPopularMovies(params?.page ?: 0) }
    }
}
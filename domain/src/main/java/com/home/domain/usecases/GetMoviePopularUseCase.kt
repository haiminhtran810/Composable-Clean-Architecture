package com.home.domain.usecases

import com.home.domain.model.movie.Movie
import com.home.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher

class GetMoviePopularUseCase(
    private val movieRepository: MovieRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<GetMoviePopularUseCase.Params, List<Movie>>(dispatcher) {

    data class Params(val page: Int)

    override suspend fun execute(params: Params): List<Movie> {
        return movieRepository.getPopularMovies(params.page)
    }
}
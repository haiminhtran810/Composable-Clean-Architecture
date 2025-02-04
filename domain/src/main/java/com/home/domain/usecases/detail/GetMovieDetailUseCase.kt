package com.home.domain.usecases.detail

import com.home.domain.model.movie.Movie
import com.home.domain.repository.MovieRepository
import com.home.domain.usecases.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMovieDetailUseCase(
    private val movieRepository: MovieRepository,
    dispatcher: CoroutineDispatcher
) : UseCase<GetMovieDetailUseCase.Params, Movie>(dispatcher) {

    data class Params(val movieId: String)

    override fun execute(params: Params?): Flow<Movie> {
        return flow { movieRepository.getMovieDetail(params?.movieId ?: "") }
    }
}
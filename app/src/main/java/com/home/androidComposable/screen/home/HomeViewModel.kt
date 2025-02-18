package com.home.androidComposable.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.home.androidComposable.utils.Constants
import com.home.domain.usecases.GetMovieNowPlayingUseCase
import com.home.domain.usecases.GetMoviePopularUseCase
import com.home.domain.usecases.GetMovieTopRatedUseCase
import com.home.domain.usecases.GetMovieUpcomingUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class HomeViewModel(
    private val getMoviePopularUseCase: GetMoviePopularUseCase,
    private val getMovieTopRatedUseCase: GetMovieTopRatedUseCase,
    private val getMovieUpcomingUseCase: GetMovieUpcomingUseCase,
    private val getMovieNowPlayingUseCase: GetMovieNowPlayingUseCase
) : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()

    init {
        getPopular()
        getTopRateMovies()
        getUpcomingMovies()
        getNowPlaying()
    }

    private fun getPopular() {
        viewModelScope.launch {
            getMoviePopularUseCase.invoke(GetMoviePopularUseCase.Params(Constants.DEFAULT_PAGE_INDEX))
                .catch {
                    Timber.e(it)
                }.collect { rsp ->
                    rsp.onSuccess { movies ->

                    }
                }
        }
    }

    private fun getTopRateMovies() {
        viewModelScope.launch {
            getMovieTopRatedUseCase.invoke(GetMovieTopRatedUseCase.Params(Constants.DEFAULT_PAGE_INDEX))
                .catch {
                    Timber.e(it)
                }.collect { rsp ->
                    rsp.onSuccess { movies ->

                    }
                }
        }
    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            getMovieUpcomingUseCase.invoke(GetMovieUpcomingUseCase.Params(Constants.DEFAULT_PAGE_INDEX))
                .catch {
                    Timber.e(it)
                }.collect { rsp ->
                    rsp.onSuccess { movies ->

                    }
                }
        }
    }

    private fun getNowPlaying() {
        viewModelScope.launch {
            getMovieNowPlayingUseCase.invoke(GetMovieNowPlayingUseCase.Params(Constants.DEFAULT_PAGE_INDEX))
                .catch {
                    Timber.e(it)
                }.collect { rsp ->
                    rsp.onSuccess { movies ->

                    }
                }
        }
    }
}
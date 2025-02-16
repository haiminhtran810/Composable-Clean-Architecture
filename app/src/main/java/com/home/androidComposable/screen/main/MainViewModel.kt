package com.home.androidComposable.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.home.domain.model.movie.Movie
import com.home.domain.usecases.detail.GetMoviePopularUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(private val getMoviePopularUseCase: GetMoviePopularUseCase) : ViewModel() {
    fun getPopular() {
        viewModelScope.launch {
            Timber.i("getPopular")
            getMoviePopularUseCase.invoke(GetMoviePopularUseCase.Params(1)).catch {
                Timber.i("getPopular + ${it.message}")
                Timber.e(it)
            }.collect {

            }
        }
    }
}
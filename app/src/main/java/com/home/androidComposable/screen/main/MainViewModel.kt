package com.home.androidComposable.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.home.domain.usecases.GetMoviePopularUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(private val getMoviePopularUseCase: GetMoviePopularUseCase) : ViewModel() {
    fun getPopular() {
        viewModelScope.launch {
            getMoviePopularUseCase.invoke(GetMoviePopularUseCase.Params(1)).catch {
                Timber.e(it)
            }.collect {

            }
        }
    }
}
package com.home.androidComposable.di

import com.home.androidComposable.screen.main.MainViewModel
import com.home.androidComposable.screen.detail.MovieDetailViewModel
import com.home.androidComposable.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { HomeViewModel(get(), get(), get(), get()) }
}
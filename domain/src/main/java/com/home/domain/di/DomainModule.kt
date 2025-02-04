package com.home.domain.di

import com.home.domain.usecases.detail.GetMovieDetailUseCase
import com.home.domain.usecases.detail.GetMoviePopularUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMoviePopularUseCase(get(), get())
    }
    factory {
        GetMovieDetailUseCase(get(), get())
    }
}
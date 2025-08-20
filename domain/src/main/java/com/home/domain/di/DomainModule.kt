package com.home.domain.di

import com.home.domain.usecases.GetMovieNowPlayingUseCase
import com.home.domain.usecases.detail.GetMovieDetailUseCase
import com.home.domain.usecases.GetMoviePopularUseCase
import com.home.domain.usecases.GetMovieTopRatedUseCase
import com.home.domain.usecases.GetMovieUpcomingUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetMoviePopularUseCase(get(), get())
    }
    factory {
        GetMovieUpcomingUseCase(get(), get())
    }
    factory {
        GetMovieTopRatedUseCase(get(), get())
    }
    factory {
        GetMovieNowPlayingUseCase(get(), get())
    }
    factory {
        GetMovieDetailUseCase(get(), get())
    }
}
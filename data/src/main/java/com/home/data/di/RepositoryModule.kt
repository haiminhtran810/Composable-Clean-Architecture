package com.home.data.di

import com.home.data.service.repository.MovieRepositoryImpl
import com.home.domain.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(movieApi = get())
    }
}
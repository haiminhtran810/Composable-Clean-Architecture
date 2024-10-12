package com.home.data.di

import com.home.data.service.repository.AddressRepositoryImpl
import com.home.data.service.repository.WeatherRepositoryImpl
import com.home.domain.repository.AddressRepository
import com.home.domain.repository.WeatherRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AddressRepository> {
        AddressRepositoryImpl(weatherApi = get())
    }
    single<WeatherRepository> {
        WeatherRepositoryImpl(weatherApi = get())
    }
}
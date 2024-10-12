package com.home.domain.di

import com.home.domain.usecases.weather.GetCurrentWeatherByCityUseCase
import com.home.domain.usecases.weather.GetDailyWeatherUseCase
import com.home.domain.usecases.weather.GetHourlyWeatherUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetCurrentWeatherByCityUseCase(get(), get())
    }
    factory {
        GetDailyWeatherUseCase(get(), get())
    }
    factory {
        GetHourlyWeatherUseCase(get(), get())
    }
}
package com.home.data.di

import com.home.data.mapper.ExceptionMapper
import com.home.data.service.api.WeatherApi
import com.home.data.service.builder.RetrofitBuilder
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

const val DEFAULT_SERVICE = "DEFAULT_SERVICE"

val networkModule = module {
    factory { provideExceptionMapper() }
    single(qualifier = named(DEFAULT_SERVICE)) {
        provideRetrofit(get())
    }
    single { provideWeatherAPI(get(qualifier = named(DEFAULT_SERVICE))) }
}

fun provideExceptionMapper() = ExceptionMapper()

fun provideRetrofit(
    retrofitBuilder: RetrofitBuilder,
): Retrofit {
    return retrofitBuilder.build()
}

fun provideWeatherAPI(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)
package com.home.data.di

import com.home.data.service.api.WeatherApi
import com.home.data.service.interceptor.HeaderInterceptor
import retrofit2.Retrofit

object NetworkModule {
//    fun provideRetrofit(
//        retrofitBuilder: RetrofitBuilder,
//        headerInterceptor: HeaderInterceptor
//    ): Retrofit = retrofitBuilder
//        .addInterceptors(headerInterceptor)
//        .build()

    fun provideWeatherApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)
}
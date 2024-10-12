package com.home.data.service.api

import com.home.data.service.response.OneCallResponse
import com.home.domain.model.weather.CurrentWeather
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "en",
    ): Flow<CurrentWeather>

    @GET("onecall")
    fun getHourlyWeather(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("lang") lang: String = "en",
        @Query("units") units: String = "metric",
        @Query("exclude") exclude: String = "minutely,daily",
    ): Flow<OneCallResponse>

    @GET("onecall")
    fun getDailyWeather(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
        @Query("lang") lang: String = "en",
        @Query("units") units: String = "metric",
        @Query("exclude") exclude: String = "minutely,hourly",
    ): Flow<OneCallResponse>
}
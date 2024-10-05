package com.home.domain.repository

import com.home.domain.model.weather.CurrentWeather
import com.home.domain.model.weather.Daily
import com.home.domain.model.weather.Hourly
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getCurrentWeather(city: String): Flow<CurrentWeather>

    fun getHourlyWeather(lat: Double, lon: Double): Flow<List<Hourly>>

    fun getDailyWeather(lat: Double, lon: Double): Flow<List<Daily>>
}
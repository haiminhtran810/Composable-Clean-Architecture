package com.home.data.service.repository

import com.home.data.service.api.WeatherApi
import com.home.domain.model.weather.CurrentWeather
import com.home.domain.model.weather.Daily
import com.home.domain.model.weather.Hourly
import com.home.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepositoryImpl constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override fun getCurrentWeather(city: String): Flow<CurrentWeather> {
        return weatherApi.getCurrentWeather(city).map { weather ->
            // Todo: Save local data
            weather
        }
    }

    override fun getHourlyWeather(lat: Double, lon: Double): Flow<List<Hourly>> {
        return weatherApi.getHourlyWeather(lat = lat, long = lon)
            .map { response ->
                response.hourly.orEmpty()
            }
    }

    override fun getDailyWeather(lat: Double, lon: Double): Flow<List<Daily>> {
        return weatherApi.getHourlyWeather(
            lat = lat,
            long = lon
        )
            .map { response ->
                response.daily ?: emptyList()
            }
    }
}
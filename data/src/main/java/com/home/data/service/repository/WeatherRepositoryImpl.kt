package com.home.data.service.repository

import android.content.Context
import com.home.data.model.CurrentWeather
import com.home.data.model.Daily
import com.home.data.model.Hourly
import com.home.data.service.api.WeatherApi
import com.home.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WeatherRepositoryImpl constructor(
    private val context: Context,
    private val weatherApi: WeatherApi
) : WeatherRepository {
    override fun getCurrentWeather(city: String): Flow<CurrentWeather> {
        return weatherApi.getCurrentWeather(city, appId = "APP_ID").map { weather ->
            // Todo: Save local data
            weather
        }
    }

    override fun getHourlyWeather(lat: Double, lon: Double): Flow<List<Hourly>> {
        return weatherApi.getHourlyWeather(lat = lat, long = lon, appId = "APP_ID")
            .map { response ->
                response.hourly.orEmpty()
            }
    }

    override fun getDailyWeather(lat: Double, lon: Double): Flow<List<Daily>> {
        return weatherApi.getHourlyWeather(
            lat = lat,
            long = lon,
            appId = "APP_ID"
        )
            .map { response ->
                response.daily ?: emptyList()
            }
    }
}
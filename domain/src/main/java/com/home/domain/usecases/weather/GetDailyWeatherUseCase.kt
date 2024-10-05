package com.home.domain.usecases.weather

import com.home.domain.model.weather.Daily
import com.home.domain.repository.WeatherRepository
import com.home.domain.usecases.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetDailyWeatherUseCase constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: CoroutineDispatcher
) : UseCase<GetDailyWeatherUseCase.Params, List<Daily>>(dispatcher) {

    data class Params(val lat: Double, val long: Double)

    override fun execute(params: Params?): Flow<List<Daily>> {
        val lat = (params?.lat ?: 0).toDouble()
        val lon = (params?.long ?: 0).toDouble()
        return weatherRepository.getDailyWeather(lat, lon)
    }
}
package com.home.domain.usecases.weather

import com.home.domain.model.weather.CurrentWeather
import com.home.domain.repository.WeatherRepository
import com.home.domain.usecases.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetCurrentWeatherByCityUseCase constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: CoroutineDispatcher
) : UseCase<GetCurrentWeatherByCityUseCase.Params, CurrentWeather>(dispatcher) {
    override fun execute(params: Params?): Flow<CurrentWeather> {
        return weatherRepository.getCurrentWeather(params?.city.orEmpty())
    }

    data class Params(val city: String)
}
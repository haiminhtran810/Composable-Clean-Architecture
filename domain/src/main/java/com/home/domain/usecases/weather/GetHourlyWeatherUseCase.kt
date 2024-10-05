package com.home.domain.usecases.weather

import com.home.domain.model.weather.Hourly
import com.home.domain.repository.WeatherRepository
import com.home.domain.usecases.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Calendar
import java.util.TimeZone

class GetHourlyWeatherUseCase constructor(
    private val weatherRepository: WeatherRepository,
    private val dispatcher: CoroutineDispatcher
) : UseCase<GetHourlyWeatherUseCase.Params, GetHourlyWeatherUseCase.Response>(dispatcher) {

    override fun execute(params: Params?): Flow<Response> {
        return weatherRepository.getHourlyWeather(
            (params?.lat ?: 0).toDouble(),
            (params?.lat ?: 0).toDouble()
        ).map {
            it.drop(1)
        }.map { hourly ->
            Response(
                today = hourly.filter { it.dt <= maxToday() },
                tomorrow = hourly.filter { it.dt > maxToday() && it.dt <= maxTomorrow() }
            )
        }
    }

    data class Params(val lat: Double, val long: Double)

    private fun maxToday(): Long {
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        calendar.add(Calendar.DATE, 1)
        calendar.set(Calendar.HOUR_OF_DAY, 6)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        return calendar.timeInMillis / 1000L
    }

    private fun maxTomorrow(): Long {
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        calendar.add(Calendar.DATE, 2)
        calendar.set(Calendar.HOUR_OF_DAY, 6)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        return calendar.timeInMillis / 1000L
    }

    data class Response(val today: List<Hourly>, val tomorrow: List<Hourly>)

    companion object {
        private const val MAX_WEATHERS_ON_DAY = 20
    }
}
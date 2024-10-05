package com.home.data.service.repository

import android.content.Context
import com.home.data.service.api.WeatherApi
import com.home.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow

class AddressRepositoryImpl constructor(
    private val context: Context,
    private val weatherApi: WeatherApi
) : AddressRepository {
    override fun getLastCityName(): Flow<String> {
        TODO("Not yet implemented")
    }
}
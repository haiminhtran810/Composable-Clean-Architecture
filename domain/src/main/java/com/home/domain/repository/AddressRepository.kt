package com.home.domain.repository

import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    fun getLastCityName(): Flow<String>
}
package com.home.domain.usecases.address

import com.home.domain.repository.AddressRepository
import com.home.domain.usecases.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetLastCityUseCase constructor(
    private val addressRepository: AddressRepository,
    private val dispatcher: CoroutineDispatcher
) : UseCase<Void, String>(dispatcher) {
    override fun execute(params: Void?): Flow<String> {
        return addressRepository.getLastCityName()
    }
}
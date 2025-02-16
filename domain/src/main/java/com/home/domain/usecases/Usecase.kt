package com.home.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class UseCase<in P, R>(private val dispatcher: CoroutineDispatcher) {
    operator fun invoke(params: P): Flow<Result<R>> = flow {
        emit(Result.success(execute(params)))
    }.catch { e ->
        emit(Result.failure(e))
    }.flowOn(dispatcher)

    protected abstract suspend fun execute(params: P): R
}
package com.home.domain.interactors

interface UseCase<in P, out R> {
    suspend fun execute(params: P): R
}

typealias Empty = Unit
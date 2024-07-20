package com.example.ethantelefonicatest.domain.usecase

abstract class BaseUseCase<in Params, out T> {
    abstract suspend fun execute(params: Params): T
}
package com.example.ethantelefonicatest.domain.usecase

import com.example.ethantelefonicatest.domain.model.UserBO
import com.example.ethantelefonicatest.domain.repository.UserRepository

class GetUserDetailUseCase(private val userRepo: UserRepository): BaseUseCase<Int, UserBO?>() {
    override suspend fun execute(params: Int): UserBO? {
        return userRepo.getUserDetail(params)
    }
}
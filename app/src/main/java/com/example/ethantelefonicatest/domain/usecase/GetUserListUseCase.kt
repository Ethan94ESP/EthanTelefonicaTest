package com.example.ethantelefonicatest.domain.usecase

import com.example.ethantelefonicatest.domain.model.UserBO
import com.example.ethantelefonicatest.domain.repository.UserRepository

class GetUserListUseCase(private val userRepo: UserRepository): BaseUseCase<Unit, List<UserBO>>() {
    override suspend fun execute(params: Unit): List<UserBO> {
        return userRepo.getUserList()
    }
}
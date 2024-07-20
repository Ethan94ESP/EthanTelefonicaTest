package com.example.ethantelefonicatest.data.repository

import com.example.ethantelefonicatest.data.network.ReqresApi
import com.example.ethantelefonicatest.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: ReqresApi): UserRepository{
}
package com.example.ethantelefonicatest.data.repository

import com.example.ethantelefonicatest.data.datasource.UserDataSource
import com.example.ethantelefonicatest.domain.model.UserBO
import com.example.ethantelefonicatest.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dataSources: UserDataSource): UserRepository {

    override suspend fun getUserList(): List<UserBO> = dataSources.getUserList().map { it.toModel() }

    override suspend fun getUserDetail(id: Int): UserBO? = dataSources.getUserDetail(id)?.toModel()
}
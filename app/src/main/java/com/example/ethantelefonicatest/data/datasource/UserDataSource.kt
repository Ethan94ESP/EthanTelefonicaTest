package com.example.ethantelefonicatest.data.datasource

import com.example.ethantelefonicatest.data.network.dto.UserDTO

interface UserDataSource {
    suspend fun getUserList(): List<UserDTO>
    suspend fun getUserDetail(id: Int): UserDTO?
}
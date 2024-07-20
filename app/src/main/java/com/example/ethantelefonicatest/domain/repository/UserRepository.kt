package com.example.ethantelefonicatest.domain.repository

import com.example.ethantelefonicatest.domain.model.UserBO

interface UserRepository {
    suspend fun getUserList(): List<UserBO>
    suspend fun getUserDetail(id: Int): UserBO?
}
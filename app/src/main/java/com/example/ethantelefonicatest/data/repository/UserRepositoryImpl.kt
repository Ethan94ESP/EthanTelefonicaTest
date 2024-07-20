package com.example.ethantelefonicatest.data.repository

import android.util.Log
import com.example.ethantelefonicatest.data.network.ReqresApi
import com.example.ethantelefonicatest.domain.model.UserBO
import com.example.ethantelefonicatest.domain.repository.UserRepository
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: ReqresApi): UserRepository{
    override suspend fun getUserList(): List<UserBO> {
        var userData: List<UserBO> = emptyList()

        api.getUserList(1)
            .onSuccess {
                Log.d("getUserList", "success")
                userData = data.toModel()
            }
            .onError {
                Log.d("getUserList", "error - ${this.message()}")
            }
            .onException {
                Log.d("getUserList", "exception - ${this.message}")
            }

        return userData
    }
}
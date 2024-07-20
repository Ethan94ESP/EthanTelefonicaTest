package com.example.ethantelefonicatest.data.datasource

import android.util.Log
import com.example.ethantelefonicatest.data.network.ReqresApi
import com.example.ethantelefonicatest.data.network.dto.UserDTO
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onSuccess
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val api: ReqresApi): UserDataSource {
    override suspend fun getUserList(): List<UserDTO> {
        var userData: List<UserDTO> = emptyList()

        api.getUserList(1)
            .onSuccess {
                Log.d("getUserList", "success")
                userData = data.data
            }
            .onError {
                Log.d("getUserList", "error - ${this.message()}")
            }
            .onException {
                Log.d("getUserList", "exception - ${this.message}")
            }
        return userData
    }

    override suspend fun getUserDetail(id: Int): UserDTO? {
        var userData: UserDTO? = null

        api.getUserDetail(id)
            .onSuccess {
                Log.d("getUserList", "success")
                userData = data.data
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
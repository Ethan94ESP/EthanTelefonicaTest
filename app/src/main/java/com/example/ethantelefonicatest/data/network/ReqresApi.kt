package com.example.ethantelefonicatest.data.network

import com.example.ethantelefonicatest.data.network.dto.UserResponseDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresApi {

    @GET("users")
    suspend fun getUserList(@Query("page") page: Int): ApiResponse<UserResponseDTO>

    companion object{
        const val baseUrl = "https://reqres.in/api/"
    }
}
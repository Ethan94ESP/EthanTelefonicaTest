package com.example.ethantelefonicatest.data.network

import com.example.ethantelefonicatest.data.network.dto.UserDetailResponseDTO
import com.example.ethantelefonicatest.data.network.dto.UserListResponseDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqresApi {

    @GET("users")
    suspend fun getUserList(@Query("page") page: Int): ApiResponse<UserListResponseDTO>

    @GET("users/{id}")
    suspend fun getUserDetail(@Path("id") id: Int): ApiResponse<UserDetailResponseDTO>

    companion object{
        const val baseUrl = "https://reqres.in/api/"
    }
}
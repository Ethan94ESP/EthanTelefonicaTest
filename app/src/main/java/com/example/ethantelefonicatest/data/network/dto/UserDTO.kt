package com.example.ethantelefonicatest.data.network.dto

import com.example.ethantelefonicatest.domain.model.UserBO
import com.squareup.moshi.Json

data class UserDTO(
    val id: Int,
    val email: String,
    @Json(name="first_name")
    val firstName: String,
    @Json(name="last_name")
    val lastName: String,
    val avatar: String
) {
    fun toModel() = UserBO(
        id = id,
        email = email,
        name = "$firstName $lastName",
        image = avatar
    )
}

data class SupportDTO(
    val url: String,
    val text: String
)

data class UserResponseDTO(
    val page: Int,
    @Json(name="per_page")
    val perPage: Int,
    val total: Int,
    @Json(name="total_pages")
    val totalPages: Int,
    val data: List<UserDTO>,
    val support: SupportDTO
) {
    fun toModel(): List<UserBO> =
        data.map { it.toModel() }
}

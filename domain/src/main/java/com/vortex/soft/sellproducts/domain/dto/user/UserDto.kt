package com.vortex.soft.sellproducts.domain.dto.user

data class UserDto (
    val id: Int,
    val name: String,
    val surname: String,
    val email: String,
    val location: String,
    val phone: String,
    val imageUrl: String
)
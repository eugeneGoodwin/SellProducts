package com.vortex.soft.sellproducts.domain.dto.register

data class RegisterDto(
        val username: String,
        val email: String,
        val password: String,
        val passwordConfirm: String)
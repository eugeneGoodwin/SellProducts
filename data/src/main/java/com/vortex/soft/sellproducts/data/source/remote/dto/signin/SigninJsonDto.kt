package com.vortex.soft.sellproducts.data.source.remote.dto.signin

import com.google.gson.annotations.SerializedName

data class SigninJsonDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)
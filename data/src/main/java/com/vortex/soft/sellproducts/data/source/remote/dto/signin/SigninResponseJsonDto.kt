package com.vortex.soft.sellproducts.data.source.remote.dto.signin

import com.google.gson.annotations.SerializedName

data class SigninResponseJsonDto (
    @SerializedName("token")
    val token: String,
    @SerializedName("refresh_token")
    val refreshToken: String
)
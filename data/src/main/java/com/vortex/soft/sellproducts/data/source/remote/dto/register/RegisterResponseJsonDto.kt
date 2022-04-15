package com.vortex.soft.sellproducts.data.source.remote.dto.register

import com.google.gson.annotations.SerializedName

class RegisterResponseJsonDto (
    @SerializedName("token")
    val token: String,
    @SerializedName("refresh_token")
    val refreshToken: String
)
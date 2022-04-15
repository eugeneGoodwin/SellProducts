package com.vortex.soft.sellproducts.data.source.remote.dto.register

import com.google.gson.annotations.SerializedName

class RegisterJsonDto (
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("confirm_password")
    val passwordConfirm: String
)
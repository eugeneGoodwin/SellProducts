package com.vortex.soft.sellproducts.data.source.remote.dto.user

import com.google.gson.annotations.SerializedName

data class UserJsonDto (
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("surname")
        val surname: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("location")
        val location: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("img_url")
        val imageUrl: String
)
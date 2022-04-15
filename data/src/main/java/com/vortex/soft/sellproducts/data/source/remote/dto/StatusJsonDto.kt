package com.vortex.soft.sellproducts.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class StatusJsonDto(
    @SerializedName("status")
    val status: String
)
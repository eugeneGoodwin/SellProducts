package com.vortex.soft.sellproducts.data.source.remote.dto.order

import com.google.gson.annotations.SerializedName

data class OrderItemJsonDto (
        @SerializedName("product_id")
        val productId: Int,
        @SerializedName("quantity")
        val quantity: Int,
        @SerializedName("price")
        val price: String,
        @SerializedName("total_price")
        val totalPrice: String
)
package com.vortex.soft.sellproducts.data.source.remote.dto.order

import com.google.gson.annotations.SerializedName
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto

data class OrderJsonDto (
        @SerializedName("id")
        val id: String,
        @SerializedName("user_id")
        val userId: Int,
        @SerializedName("description")
        val description: String,
        @SerializedName("total_price")
        val totalPrice: String,
        @SerializedName("order_date")
        val orderDate: String,
        @SerializedName("order_items")
        val listOrderItems: List<OrderItemJsonDto>,
        @SerializedName("status")
        val status: String
)
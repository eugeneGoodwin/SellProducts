package com.vortex.soft.sellproducts.domain.dto.order

data class OrderItemDto (
    val productId: Int,
    val quantity: Int,
    val price: String,
    val totalPrice: String
)
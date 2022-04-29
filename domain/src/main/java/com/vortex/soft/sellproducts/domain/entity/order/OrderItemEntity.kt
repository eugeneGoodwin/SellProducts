package com.vortex.soft.sellproducts.domain.entity.order

import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto

class OrderItemEntity (val productId: Int,
                       val productDesciption: String,
                       val productImageUrl: String,
                       var quantity: Int,
                       val price: String){
    val totalPrice: String
        get() = (price.toInt() * quantity).toString()

    constructor(dto: OrderItemDto):this(dto.productId, dto.productDescription, dto.productImageUrl, dto.quantity, dto.price)
    fun toDTO() = OrderItemDto(productId, productDesciption, productImageUrl, quantity, price, totalPrice)
}
package com.vortex.soft.sellproducts.data.mapper.order

import com.vortex.soft.sellproducts.data.mapper.common.JsonMapper
import com.vortex.soft.sellproducts.data.source.remote.dto.order.OrderItemJsonDto
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto

class OrderItemMapper : JsonMapper<OrderItemDto, OrderItemJsonDto> {
    override fun mapDomainToJson(type: OrderItemDto): OrderItemJsonDto {
        return OrderItemJsonDto(
            type.productId,
            type.quantity,
            type.price,
            type.totalPrice
        )
    }
    override fun mapJsonToDomain(type: OrderItemJsonDto): OrderItemDto {
        return OrderItemDto(
            type.productId,
            type.quantity,
            type.price,
            type.totalPrice
        )
    }
}
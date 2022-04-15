package com.vortex.soft.sellproducts.data.mapper.order

import com.vortex.soft.sellproducts.data.mapper.common.JsonMapper
import com.vortex.soft.sellproducts.data.source.remote.dto.order.OrderJsonDto
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto

class OrderMapper(val itemMapper: OrderItemMapper): JsonMapper<OrderDto, OrderJsonDto> {
    override fun mapDomainToJson(type: OrderDto): OrderJsonDto {
        return OrderJsonDto(
                type.id,
                type.userId,
                type.description,
                type.totalPrice,
                type.orderDate,
                type.listOrderItems.map { itemMapper.mapDomainToJson(it) },
                type.status
        )
    }
    override fun mapJsonToDomain(type: OrderJsonDto): OrderDto {
        return OrderDto(
                type.id,
                type.userId,
                type.description,
                type.totalPrice,
                type.orderDate,
                type.listOrderItems.map { itemMapper.mapJsonToDomain(it) },
                type.status
        )
    }
}
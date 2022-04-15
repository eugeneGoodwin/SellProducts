package com.vortex.soft.sellproducts.domain.repository

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto


interface OrderRepository {
    fun sendOrder(order: OrderDto): Either<FailureType, Boolean>
    fun getOrders(): Either<FailureType, List<OrderDto>>
}
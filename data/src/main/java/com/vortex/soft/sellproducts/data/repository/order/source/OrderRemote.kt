package com.vortex.soft.sellproducts.data.repository.order.source

import com.vortex.soft.sellproducts.data.source.remote.dto.StatusJsonDto
import com.vortex.soft.sellproducts.data.source.remote.dto.order.OrderJsonDto
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

interface OrderRemote {
    fun sendOrder(token: String, order: OrderJsonDto): Either<FailureType, StatusJsonDto>
    fun getOrders(token: String): Either<FailureType, List<OrderJsonDto>>
}
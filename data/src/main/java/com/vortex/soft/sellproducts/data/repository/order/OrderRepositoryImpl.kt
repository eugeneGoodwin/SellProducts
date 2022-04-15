package com.vortex.soft.sellproducts.data.repository.order

import com.vortex.soft.sellproducts.data.mapper.order.OrderMapper
import com.vortex.soft.sellproducts.data.repository.common.PreferencesProvider
import com.vortex.soft.sellproducts.data.repository.order.source.OrderRemote
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.monad.flatMap
import com.vortex.soft.sellproducts.domain.common.monad.map
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.domain.repository.OrderRepository

class OrderRepositoryImpl (
        private val remote: OrderRemote,
        private val prefProvider: PreferencesProvider,
        private val mapper: OrderMapper
): OrderRepository {

    override fun getOrders(): Either<FailureType, List<OrderDto>> {
        return prefProvider.getToken().flatMap { token ->
            remote.getOrders(token).map { it.map { mapper.mapJsonToDomain(it)} }
        }
    }

    override fun sendOrder(order: OrderDto): Either<FailureType, Boolean> {
        return prefProvider.getToken().flatMap { token ->
            remote.sendOrder(token, mapper.mapDomainToJson(order)).map { if(it.status == "success") true else false }
        }
    }
}
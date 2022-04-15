package com.vortex.soft.sellproducts.data.source.remote.rest.provider.order

import com.vortex.soft.sellproducts.data.repository.order.source.OrderRemote
import com.vortex.soft.sellproducts.data.source.remote.dto.StatusJsonDto
import com.vortex.soft.sellproducts.data.source.remote.dto.order.OrderJsonDto
import com.vortex.soft.sellproducts.data.source.remote.rest.common.RestAdapter
import com.vortex.soft.sellproducts.data.source.remote.rest.common.SellProductsAPI
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

class OrderRemoteImpl (
        private val apiService: SellProductsAPI,
        private val restAdapter: RestAdapter
) : OrderRemote {

    override fun getOrders(token: String): Either<FailureType, List<OrderJsonDto>> {
        return restAdapter.make(apiService.getOrders(token), { it })
    }

    override fun sendOrder(token: String, order: OrderJsonDto): Either<FailureType, StatusJsonDto> {
        return restAdapter.make(apiService.sendOrder(token, order), { it })
    }
}
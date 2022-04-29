package com.vortex.soft.sellproducts.domain.interactor.usecases.cart

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.domain.interactor.base.Interactor
import com.vortex.soft.sellproducts.domain.repository.CartRepository

class AddOrderItemToCartUseCase (private val repository: CartRepository
) : Interactor<OrderItemDto, Boolean>() {

    override suspend fun run(params: OrderItemDto): Either<FailureType, Boolean> {
        return repository.addOrderItemToCart(params)
    }
}
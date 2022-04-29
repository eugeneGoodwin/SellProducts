package com.vortex.soft.sellproducts.domain.interactor.usecases.cart

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.domain.interactor.base.Interactor
import com.vortex.soft.sellproducts.domain.repository.CartRepository

class CreateCartUseCase (private val repository: CartRepository
) : Interactor<OrderDto, Boolean>() {

    override suspend fun run(params: OrderDto): Either<FailureType, Boolean> {
        return repository.createCart(params)
    }
}
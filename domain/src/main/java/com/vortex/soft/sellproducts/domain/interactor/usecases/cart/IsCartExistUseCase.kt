package com.vortex.soft.sellproducts.domain.interactor.usecases.cart

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.interactor.base.Interactor
import com.vortex.soft.sellproducts.domain.repository.CartRepository

class IsCartExistUseCase (private val repository: CartRepository
) : Interactor<None, Boolean>() {

    override suspend fun run(params: None): Either<FailureType, Boolean> {
        return repository.isCartExist()
    }
}
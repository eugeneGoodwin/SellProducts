package com.vortex.soft.sellproducts.domain.interactor.usecases.product

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.domain.interactor.base.Interactor
import com.vortex.soft.sellproducts.domain.repository.ProductRepository

class GetProductsUseCase( private val repository: ProductRepository
) : Interactor<None, List<ProductDto>>() {

    override suspend fun run(params: None): Either<FailureType, List<ProductDto>> {
        return repository.getProducts()
    }
}
package com.vortex.soft.sellproducts.domain.repository

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto

interface ProductRepository {
    fun getProducts(): Either<FailureType, List<ProductDto>>
}
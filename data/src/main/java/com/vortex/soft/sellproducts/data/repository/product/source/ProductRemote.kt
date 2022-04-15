package com.vortex.soft.sellproducts.data.repository.product.source

import com.vortex.soft.sellproducts.data.source.remote.dto.product.ProductJsonDto
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

interface ProductRemote {
    fun getProducts(token: String): Either<FailureType, List<ProductJsonDto>>
}
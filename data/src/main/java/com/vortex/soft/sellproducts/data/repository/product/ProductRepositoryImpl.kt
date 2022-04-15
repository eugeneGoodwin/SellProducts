package com.vortex.soft.sellproducts.data.repository.product

import com.vortex.soft.sellproducts.data.mapper.product.ProductMapper
import com.vortex.soft.sellproducts.data.repository.common.PreferencesProvider
import com.vortex.soft.sellproducts.data.repository.product.source.ProductRemote
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.monad.flatMap
import com.vortex.soft.sellproducts.domain.common.monad.map
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val remote: ProductRemote,
    private val prefProvider: PreferencesProvider,
    private val mapper: ProductMapper
): ProductRepository {

    override fun getProducts(): Either<FailureType, List<ProductDto>> {
        return prefProvider.getToken().flatMap { token ->
            remote.getProducts(token).map { it.map { mapper.mapJsonToDomain(it)} }
        }
    }
}
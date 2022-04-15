package com.vortex.soft.sellproducts.data.source.remote.rest.provider.product

import com.vortex.soft.sellproducts.data.repository.product.source.ProductRemote
import com.vortex.soft.sellproducts.data.source.remote.dto.product.ProductJsonDto
import com.vortex.soft.sellproducts.data.source.remote.rest.common.RestAdapter
import com.vortex.soft.sellproducts.data.source.remote.rest.common.SellProductsAPI
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

class ProductRemoteImpl (
    private val apiService: SellProductsAPI,
    private val restAdapter: RestAdapter
) : ProductRemote {

    override fun getProducts(token: String): Either<FailureType, List<ProductJsonDto>> {
        return restAdapter.make(apiService.getProducts(token), { it })
    }
}
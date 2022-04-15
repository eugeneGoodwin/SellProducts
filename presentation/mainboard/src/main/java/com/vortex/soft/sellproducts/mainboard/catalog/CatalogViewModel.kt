package com.vortex.soft.sellproducts.mainboard.catalog

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.domain.interactor.usecases.product.GetProductsUseCase

class CatalogViewModel(
    val getProductsUseCase: GetProductsUseCase
) : BaseViewModel() {
    var productsData: MutableLiveData<List<ProductDto>> = MutableLiveData()

    fun getProducts() = getProductsUseCase(None()) { it.eitherHandle(::handleFailure, ::handleProducts) }

    private fun handleProducts(listProductDto: List<ProductDto>) {
        productsData.value = listProductDto
    }

    fun addToCart(orderItem: OrderItemDto) {}
}
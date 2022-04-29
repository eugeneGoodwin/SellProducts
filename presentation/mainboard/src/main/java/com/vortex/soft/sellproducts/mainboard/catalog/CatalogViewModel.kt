package com.vortex.soft.sellproducts.mainboard.catalog

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.domain.entity.order.OrderEntity
import com.vortex.soft.sellproducts.domain.interactor.usecases.cart.AddOrderItemToCartUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.cart.CreateCartUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.cart.IsCartExistUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.product.GetProductsUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.user.GetCurrentUserIdUseCase
import com.vortex.soft.sellproducts.utils.DateTimeUtil

class CatalogViewModel(
    val getProductsUseCase: GetProductsUseCase,
    val createCartUseCase: CreateCartUseCase,
    val isCartExistUseCase: IsCartExistUseCase,
    val currentUserIdUseCase: GetCurrentUserIdUseCase,
    val addOrderItemToCartUseCase: AddOrderItemToCartUseCase
) : BaseViewModel() {
    var orderItem: OrderItemDto? = null
    var productsData: MutableLiveData<List<ProductDto>> = MutableLiveData()

    fun getProducts() = getProductsUseCase(None()) { it.eitherHandle(::handleFailure, ::handleProducts) }

    private fun handleProducts(listProductDto: List<ProductDto>) {
        productsData.value = listProductDto
    }

    fun addToCart(orderItemDto: OrderItemDto) {
        orderItem = orderItemDto
        isCartExistUseCase(None()) { it.eitherHandle(::handleFailure, ::handleCartExist) }
    }

    private fun handleCartExist(isExist: Boolean) {
        if(!isExist) {
            val currentUserId = currentUserIdUseCase(None())
            currentUserId.toIntOrNull()?.let {
                createCartUseCase(initCart(it)) { it.eitherHandle(::handleFailure, ::handleCreateCart) }
            } ?: run { handleFailure(FailureType.CurrentUserError) }
        } else {
            orderItem?.let { addOrderItemToCartUseCase(it) { it.eitherHandle(::handleFailure, ::handleAddOrderItem) } }
        }
    }

    private fun handleCreateCart(isCreated: Boolean) {
        if(isCreated) orderItem?.let { addOrderItemToCartUseCase(it) { it.eitherHandle(::handleFailure, ::handleAddOrderItem) } }
    }

    private fun handleAddOrderItem(isAdded: Boolean) {}

    fun initCart(currentUserId: Int): OrderDto {
        return OrderEntity(currentUserId, "", DateTimeUtil.getCurrentDateString(), "new").toDTO()
    }
}
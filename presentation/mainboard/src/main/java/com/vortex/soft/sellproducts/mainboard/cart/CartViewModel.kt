package com.vortex.soft.sellproducts.mainboard.cart

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.domain.interactor.usecases.cart.GetCartUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.cart.IsCartExistUseCase

class CartViewModel (
    val getCartUseCase: GetCartUseCase,
    val isCartExistUseCase: IsCartExistUseCase
) : BaseViewModel() {
    var order: MutableLiveData<OrderDto> = MutableLiveData()
    var isCartExistLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun getCart() = getCartUseCase(None()) { it.eitherHandle(::handleFailure, ::handleCart) }

    private fun handleCart(orderDto: OrderDto) {
        order.value = orderDto
    }

    fun isCartExist() = isCartExistUseCase(None()) { it.eitherHandle(::handleFailure, ::handleCartExist) }

    private fun handleCartExist(isExist: Boolean) {
        isCartExistLiveData.value = isExist
    }
}
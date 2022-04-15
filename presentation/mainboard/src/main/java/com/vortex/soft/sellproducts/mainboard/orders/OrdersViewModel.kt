package com.vortex.soft.sellproducts.mainboard.orders

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.domain.interactor.usecases.order.GetOrdersUseCase

class OrdersViewModel(val getOrdersUseCase: GetOrdersUseCase) : BaseViewModel() {
    var ordersData: MutableLiveData<List<OrderDto>> = MutableLiveData()

    fun getOrders() = getOrdersUseCase(None()) { it.eitherHandle(::handleFailure, ::handleOrders) }

    private fun handleOrders(listOrderDto: List<OrderDto>) {
        ordersData.value = listOrderDto
    }
}
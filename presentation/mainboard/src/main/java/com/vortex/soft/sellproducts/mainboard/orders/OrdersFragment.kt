package com.vortex.soft.sellproducts.mainboard.orders

import android.os.Bundle
import android.view.View
import com.vortex.soft.sellproducts.base.presentation.base.BaseFragment
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.hide
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.observeOnce
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.show
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.viewModelInit
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.fragment_orders.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel


class OrdersFragment : BaseFragment(), AndroidScopeComponent {

    override val scope by fragmentScope()

    private val ordersViewModel: OrdersViewModel by viewModel()

    private val orderAdapter: OrderAdapter by inject()

    override fun layoutId(): Int = R.layout.fragment_orders

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeViewModel()
    }

    override fun initializeViews(view: View) {
        initializeRecyclerView()
        getOrders()
    }

    private fun getOrders() {
        openPreloader()
        ordersViewModel.getOrders()
    }

    override fun initializeViewModel() {
        viewModelInit(ordersViewModel) {
            observeOnce(ordersData, ::handleOrders)
            observeOnce(failureData, ::handleError)
        }
    }


    private fun initializeRecyclerView() {
        with(listOrders) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = orderAdapter
        }
    }

    private fun handleOrders(orders: List<OrderDto>?) {
        closePreloader()
        orderAdapter.ordersList = orders?.toMutableList() ?: mutableListOf()
    }

    private fun handleError(fail: FailureType?) { closePreloader() }

    override fun openPreloader() {
        preloaderLayout.show()
        mainLayout.hide()
    }

    override fun closePreloader() {
        preloaderLayout.hide()
        mainLayout.show()
    }
}
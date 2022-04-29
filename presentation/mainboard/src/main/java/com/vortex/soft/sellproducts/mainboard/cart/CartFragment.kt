package com.vortex.soft.sellproducts.mainboard.cart

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
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.fragmentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : BaseFragment(), AndroidScopeComponent {

    override val scope by fragmentScope()

    private val cartViewModel: CartViewModel by viewModel()

    lateinit var cartAdapter: CartAdapter

    override fun layoutId(): Int = R.layout.fragment_cart

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeViewModel()
    }

    override fun initializeViews(view: View) {
        cartAdapter = CartAdapter()
        initializeRecyclerView()
        cartExist()
    }

    private fun cartExist() {
        cartViewModel.isCartExist()
    }

    private fun getCart() {
        cartViewModel.getCart()
    }

    override fun initializeViewModel() {
        viewModelInit(cartViewModel) {
            observeOnce(order, ::handleOrder)
            observeOnce(isCartExistLiveData, ::handleCartExist)
            observeOnce(failureData, ::handleError)
        }
    }


    private fun initializeRecyclerView() {
        with(listOrderItems) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = cartAdapter
        }
    }

    private fun handleOrder(order: OrderDto?) {
        closePreloader()
        order?.let { initCart(it) }
    }

    private fun handleCartExist(isExist: Boolean?) {
        isExist?.let {
            if(it) {
                getCart()
            } else
                openEmptyCartLayout()
        } ?: run { openEmptyCartLayout() }
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

    fun openEmptyCartLayout() {
        preloaderLayout.hide()
        mainLayout.hide()
        emptyCartLayout.show()
    }

    fun initCart(order: OrderDto) {
        orderTotalPrice.text = order.totalPrice
        orderStatus.text = order.status
        cartAdapter.cartList = order.listOrderItems
    }
}
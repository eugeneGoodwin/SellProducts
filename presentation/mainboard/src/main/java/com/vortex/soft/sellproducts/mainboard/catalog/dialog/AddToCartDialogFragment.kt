package com.vortex.soft.sellproducts.mainboard.catalog.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.vortex.soft.sellproducts.base.presentation.base.BaseDialogFragment
import com.vortex.soft.sellproducts.base.presentation.view.CounterListner
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.domain.entity.order.OrderItemEntity
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.button_add_to_cart_layout.*
import kotlinx.android.synthetic.main.dialog_fragment_add_to_cart.*

typealias AddToCardListener = (orderItemDto: OrderItemDto) -> Unit

class AddToCartDialogFragment : BaseDialogFragment() {

    override fun getLayout(): Int = R.layout.dialog_fragment_add_to_cart

    var product: ProductDto? = null
    var orderItem: OrderItemEntity? = null
    var listener: AddToCardListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        cancelImg.setOnClickListener { dismiss() }
        addToCartButton.setOnClickListener { orderItem?.let { listener?.invoke(it.toDTO())}; dismiss() }
    }

    fun initView() {
        product?.let{
            productTitle.text = it.title
            productDescrption.text = it.description
            if(it.imageUrl.isNotEmpty()) Glide.with(this).load(it.imageUrl).into(productImg)
        }
        orderItem?.let {
            totalPrice.text = it.totalPrice
            counterProductsCart.setStartCounterValue(it.quantity.toString())
        }
        counterProductsCart.setCounterListener(
            object: CounterListner {
                override fun onIncClick(value: String) {
                    orderItem?.let {
                        it.quantity = value.toInt()
                        changeTotalPrice(it.totalPrice)
                    }
                }

                override fun onDecClick(value: String) {
                    orderItem?.let {
                        it.quantity = value.toInt()
                        changeTotalPrice(it.totalPrice)
                    }
                }
            }
        )
        //counterProductsCart.setColor(R.color.color_background_blue_2, R.color.color_background_blue_2, R.color.color_black)
    }

    fun changeTotalPrice(total: String) {
        totalPrice.text = total
    }

    companion object {
        fun display(
                activity: FragmentActivity,
                listenerDialog: AddToCardListener,
                productDto: ProductDto
        ) = AddToCartDialogFragment().apply {
            listener = listenerDialog;
            product = productDto;
            orderItem = OrderItemEntity(productDto.id.toInt(),
                    productDto.description,
                    productDto.imageUrl,
                    1,
                    productDto.price)
        }.show(activity.supportFragmentManager, "")
    }
}
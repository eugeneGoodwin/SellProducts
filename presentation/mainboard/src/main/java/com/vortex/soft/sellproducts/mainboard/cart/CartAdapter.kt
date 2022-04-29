package com.vortex.soft.sellproducts.mainboard.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.cart_item.view.*
import kotlin.properties.Delegates

class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    internal var cartList: List<OrderItemDto> by Delegates.observable(emptyList()) {
            _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
            R.layout.cart_item, parent, false
        )
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(cartList[position])
    }

    override fun getItemCount() = cartList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(orderItem: OrderItemDto) {
            with(itemView) {
                productNameText.text = orderItem.productId.toString()
                productDescriptionText.text = orderItem.productDescription
                priceText.text = orderItem.totalPrice
                if(orderItem.productImageUrl.isNotEmpty()) Glide.with(this).load(orderItem.productImageUrl).into(cartItemImage)
                counter.setStartCounterValue(orderItem.quantity.toString())
            }
        }
    }
}
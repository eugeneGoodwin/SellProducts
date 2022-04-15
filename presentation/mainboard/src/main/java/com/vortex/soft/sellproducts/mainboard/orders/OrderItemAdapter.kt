package com.vortex.soft.sellproducts.mainboard.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.order_sub_item.view.*
import kotlin.properties.Delegates

class OrderItemAdapter : RecyclerView.Adapter<OrderItemAdapter.ViewHolder>() {
    internal var orderItemsList: List<OrderItemDto> by Delegates.observable(emptyList()) {
        _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.order_sub_item, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(orderItemsList[position])
    }

    override fun getItemCount() = orderItemsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(orderItemDto: OrderItemDto) {
            with(itemView) {
                productName.text = orderItemDto.productId.toString()
                quantity.text = orderItemDto.quantity.toString()
                totalSum.text = orderItemDto.totalPrice
            }
        }
    }
}
package com.vortex.soft.sellproducts.mainboard.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vortex.soft.sellproducts.domain.dto.order.OrderDto
import com.vortex.soft.sellproducts.mainboard.R
import kotlinx.android.synthetic.main.order_item.view.*
import kotlin.properties.Delegates

class OrderAdapter: RecyclerView.Adapter<OrderAdapter.ViewHolder>() {
    internal var ordersList: List<OrderDto> by Delegates.observable(emptyList()) {
        _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(
                    R.layout.order_item, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(ordersList[position])
    }

    override fun getItemCount() = ordersList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(orderDto: OrderDto) {
            with(itemView) {
                orderIdText.text = orderDto.id
                orderDate.text = orderDto.orderDate
                orderStatus.text = orderDto.status
                val orderItemAdapter = OrderItemAdapter()
                with(orderItems) {
                    layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
                    adapter = orderItemAdapter
                }
                orderItemAdapter.orderItemsList = orderDto.listOrderItems
                orderTotalPrice.text = orderDto.totalPrice
            }
        }
    }
}
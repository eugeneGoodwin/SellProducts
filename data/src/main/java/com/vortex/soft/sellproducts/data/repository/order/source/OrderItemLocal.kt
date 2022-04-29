package com.vortex.soft.sellproducts.data.repository.order.source

import com.vortex.soft.sellproducts.data.source.local.database.room.table.OrderItemSqlEntity

interface OrderItemLocal {
    fun getById(id: Long): OrderItemSqlEntity

    fun getByOrderId(otderId: String) : List<OrderItemSqlEntity>

    fun insert(orderItem: OrderItemSqlEntity) : Long

    fun update(orderItem: OrderItemSqlEntity): Int

    fun delete(orderItem: OrderItemSqlEntity): Int

    fun deleteAll()
}
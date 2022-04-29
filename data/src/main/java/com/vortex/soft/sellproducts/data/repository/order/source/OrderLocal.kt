package com.vortex.soft.sellproducts.data.repository.order.source

import com.vortex.soft.sellproducts.data.source.local.database.room.table.OrderSqlEntity

interface OrderLocal {
    fun getById(id: Long): OrderSqlEntity

    fun getByOrderId(orderId: String) : OrderSqlEntity

    fun insert(order: OrderSqlEntity) : Long

    fun update(order: OrderSqlEntity): Int

    fun update(orderId: String, totalPrice: String): Int

    fun delete(order: OrderSqlEntity): Int

    fun deleteAll()
}
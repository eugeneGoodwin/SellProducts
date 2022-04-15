package com.vortex.soft.sellproducts.domain.dto.product

data class ProductDto(
        val id: String,
        val title: String,
        val description: String,
        val price: String,
        val oldPrice: String,
        val imageUrl: String,   //https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&dl=kari-shea-1SAnrIxw5OY-unsplash.jpg
        val categoryId: String,
        val brandId: String,
        val brandName: String,
        val groupId: String,
        val status: String, // available, not available,
        val state: String //new
)
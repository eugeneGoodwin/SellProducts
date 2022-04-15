package com.vortex.soft.sellproducts.data.source.remote.dto.product

import com.google.gson.annotations.SerializedName

data class ProductJsonDto (
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("old_price")
    val oldPrice: String,
    @SerializedName("img_url")
    val imageUrl: String,
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("brand_id")
    val brandId: String,
    @SerializedName("brand_name")
    val brandName: String,
    @SerializedName("group_id")
    val groupId: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("state")
    val state: String
)
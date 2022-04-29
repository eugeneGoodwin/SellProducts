package com.vortex.soft.sellproducts.mainboard.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vortex.soft.sellproducts.domain.dto.order.OrderItemDto
import com.vortex.soft.sellproducts.domain.dto.product.ProductDto
import com.vortex.soft.sellproducts.mainboard.R
import com.vortex.soft.sellproducts.mainboard.catalog.dialog.AddToCartDialogFragment
import kotlinx.android.synthetic.main.catalog_item.view.*
import kotlin.properties.Delegates


class CatalogAdapter(val activity: FragmentActivity, val listener: (OrderItemDto) -> Unit) : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {
    internal var productsList: List<ProductDto> by Delegates.observable(emptyList()) {
        _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.catalog_item, parent, false
            )
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(productsList[position], activity, listener)
    }

    override fun getItemCount() = productsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: ProductDto, activity: FragmentActivity, listener: (OrderItemDto) -> Unit) {
            with(itemView) {
                productNameText.text = product.title
                productDescriptionText.text = product.description
                priceText.text = product.price
                if(product.imageUrl.isNotEmpty()) Glide.with(this).load(product.imageUrl).into(productImage)
                productCard.setOnClickListener {
                    AddToCartDialogFragment.display(activity, { listener(it) }, product)
                }
            }
        }
    }
}
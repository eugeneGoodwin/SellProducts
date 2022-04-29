package com.vortex.soft.sellproducts.mainboard.di.module

import com.vortex.soft.sellproducts.mainboard.MainboardActivity
import com.vortex.soft.sellproducts.mainboard.cart.CartFragment
import com.vortex.soft.sellproducts.mainboard.cart.CartViewModel
import com.vortex.soft.sellproducts.mainboard.catalog.CatalogFragment
import com.vortex.soft.sellproducts.mainboard.catalog.CatalogViewModel
import com.vortex.soft.sellproducts.mainboard.orders.OrderAdapter
import com.vortex.soft.sellproducts.mainboard.orders.OrderItemAdapter
import com.vortex.soft.sellproducts.mainboard.orders.OrdersFragment
import com.vortex.soft.sellproducts.mainboard.orders.OrdersViewModel
import com.vortex.soft.sellproducts.mainboard.profile.ProfileFragment
import com.vortex.soft.sellproducts.mainboard.profile.ProfileViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainboardModule = module {

    viewModel { CatalogViewModel(get(), get(), get(), get(), get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { OrdersViewModel(get()) }
    viewModel { CartViewModel(get(), get()) }

    scope<MainboardActivity> {
        fragment { CatalogFragment() }
        scope<CatalogFragment> {
        }

        fragment { ProfileFragment() }
        fragment { CartFragment() }

        fragment { OrdersFragment() }
        scope<OrdersFragment> {
            scoped { OrderItemAdapter() }
            scoped { OrderAdapter() }
        }
    }
}
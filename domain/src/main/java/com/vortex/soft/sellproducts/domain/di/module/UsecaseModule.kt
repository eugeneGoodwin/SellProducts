package com.vortex.soft.sellproducts.domain.di.module

import com.vortex.soft.sellproducts.domain.interactor.usecases.order.GetOrdersUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.order.SendOrderUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.product.GetProductsUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.register.RegisterUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.signin.SigninUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.user.GetUserUseCase
import org.koin.dsl.module

val usecaseModule = module {
    factory { SigninUseCase(get()) }
    factory { RegisterUseCase(get()) }
    factory { GetProductsUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetOrdersUseCase(get()) }
    factory { SendOrderUseCase(get()) }
}
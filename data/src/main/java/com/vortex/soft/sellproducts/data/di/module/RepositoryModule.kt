package com.vortex.soft.sellproducts.data.di.module

import android.content.Context
import com.vortex.soft.sellproducts.data.mapper.order.OrderItemMapper
import com.vortex.soft.sellproducts.data.mapper.order.OrderMapper
import com.vortex.soft.sellproducts.data.mapper.product.ProductMapper
import com.vortex.soft.sellproducts.data.mapper.register.RegisterMapper
import com.vortex.soft.sellproducts.data.mapper.register.RegisterResponseMapper
import com.vortex.soft.sellproducts.data.mapper.signin.SigninMapper
import com.vortex.soft.sellproducts.data.mapper.signin.SigninResponseMapper
import com.vortex.soft.sellproducts.data.mapper.user.UserMapper
import com.vortex.soft.sellproducts.data.repository.order.OrderRepositoryImpl
import com.vortex.soft.sellproducts.data.repository.order.source.OrderRemote
import com.vortex.soft.sellproducts.data.repository.product.ProductRepositoryImpl
import com.vortex.soft.sellproducts.data.repository.product.source.ProductRemote
import com.vortex.soft.sellproducts.data.repository.register.RegisterRepositoryImpl
import com.vortex.soft.sellproducts.data.repository.register.source.RegisterRemote
import com.vortex.soft.sellproducts.data.repository.signin.SigninRepositoryImpl
import com.vortex.soft.sellproducts.data.repository.signin.source.SigninRemote
import com.vortex.soft.sellproducts.data.repository.user.UserRepositoryImpl
import com.vortex.soft.sellproducts.data.repository.user.source.UserRemote
import com.vortex.soft.sellproducts.data.source.preferences.PreferencesProviderImpl
import com.vortex.soft.sellproducts.data.source.remote.rest.common.NetworkHandler
import com.vortex.soft.sellproducts.data.source.remote.rest.common.RestAdapter
import com.vortex.soft.sellproducts.data.source.remote.rest.provider.order.OrderRemoteImpl
import com.vortex.soft.sellproducts.data.source.remote.rest.provider.product.ProductRemoteImpl
import com.vortex.soft.sellproducts.data.source.remote.rest.provider.register.RegisterRemoteImpl
import com.vortex.soft.sellproducts.data.source.remote.rest.provider.signin.SigninRemoteImpl
import com.vortex.soft.sellproducts.data.source.remote.rest.provider.user.UserRemoteImpl
import com.vortex.soft.sellproducts.domain.repository.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory { NetworkHandler(androidApplication()) }

    single { androidApplication().getSharedPreferences(androidContext().packageName, Context.MODE_PRIVATE) }

    factory <SigninRemote> { SigninRemoteImpl(get(), restAdapter = RestAdapter(get())) }
    factory <ProductRemote> { ProductRemoteImpl(get(), restAdapter = RestAdapter(get())) }
    factory <RegisterRemote> { RegisterRemoteImpl(get(), restAdapter = RestAdapter(get())) }
    factory <UserRemote> { UserRemoteImpl(get(), restAdapter = RestAdapter(get())) }
    factory <OrderRemote> { OrderRemoteImpl(get(), restAdapter = RestAdapter(get())) }

    factory <SigninRepository> { SigninRepositoryImpl(get(), mapper = SigninMapper(), responseMapper = SigninResponseMapper()) }
    factory <ProductRepository> { ProductRepositoryImpl(get(), mapper = ProductMapper(), prefProvider = PreferencesProviderImpl(get())) }
    factory <RegisterRepository> { RegisterRepositoryImpl(get(), mapper = RegisterMapper(), responseMapper = RegisterResponseMapper()) }
    factory <UserRepository> { UserRepositoryImpl(get(), mapper = UserMapper(), prefProvider = PreferencesProviderImpl(get())) }
    factory <OrderRepository> { OrderRepositoryImpl(get(), mapper = OrderMapper(OrderItemMapper()), prefProvider = PreferencesProviderImpl(get())) }
}
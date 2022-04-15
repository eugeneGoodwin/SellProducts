package com.vortex.soft.sellproducts.data.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vortex.soft.sellproducts.data.source.remote.rest.common.NetworkService
import com.vortex.soft.sellproducts.data.source.remote.rest.common.OkHttpInterceptor
import com.vortex.soft.sellproducts.data.source.remote.rest.common.SellProductsAPI
import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor.MockInterceptor
import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor.MockRequest
import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.mock_requests.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single<Gson> {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.serializeNulls()
        gsonBuilder.create()
    }
    factory<Interceptor> {
        val mockRequests = listOf<MockRequest>(
            GetProductsMockRequest(),
            SigninMockRequest(),
            RegisterMockRequest(),
            GetUserMockRequest(),
            GetOrdersMockRequest(),
            SendOrderMockRequest()
        )
        MockInterceptor(get<Context>().resources, mockRequests)
    }
    /*factory<Interceptor>  {
        OkHttpInterceptor()
    }*/
    factory<OkHttpClient> { OkHttpClient.Builder()
        .addInterceptor(get<Interceptor>())
        .build()
    }
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://www.mocky.io/v2/")
                // .baseUrl("https://www.cashberry.com.ua")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }
    single<SellProductsAPI> { NetworkService(get()) }
}
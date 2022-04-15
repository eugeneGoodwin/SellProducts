package com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor

interface MockResponse {
    fun statusCode() : Int
    fun fileResId() : Int
}
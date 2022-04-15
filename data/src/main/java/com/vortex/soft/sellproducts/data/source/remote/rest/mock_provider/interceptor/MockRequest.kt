package com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor

interface MockRequest {
    fun isMatch(requestType: String, url: String, requestBodyJson: String): Boolean
    fun response(): MockResponse
}
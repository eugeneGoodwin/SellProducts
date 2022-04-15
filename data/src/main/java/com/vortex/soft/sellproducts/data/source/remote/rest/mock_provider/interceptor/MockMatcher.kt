package com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor

class MockMatcher(val listOfMocks: List<MockRequest> = emptyList()) {
    fun match(requestType: String, url: String, requestBodyJson: String = "") : MockRequest? {
        return innerMatch(requestType, url, requestBodyJson)
    }

    private fun innerMatch(requestType: String, url: String, requestBodyJson: String): MockRequest? {
        return listOfMocks.firstOrNull { mock -> mock.isMatch(requestType, url, requestBodyJson) }
    }
}
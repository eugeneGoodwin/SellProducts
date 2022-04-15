package com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.mock_requests

import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor.MockRequest
import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor.MockResponse
import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.mock_requests.responses.GetUserMockResponse

class GetUserMockRequest : MockRequest {
    override fun isMatch(requestType: String, url: String, requestBodyJson: String): Boolean {
        return requestType.toLowerCase() == "get" && url.contains("api/user")
    }

    override fun response(): MockResponse = GetUserMockResponse()
}
package com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.mock_requests.responses

import com.vortex.soft.sellproducts.data.R
import com.vortex.soft.sellproducts.data.source.remote.rest.mock_provider.interceptor.MockResponse

class GetUserMockResponse : MockResponse {
    override fun fileResId(): Int = R.raw.get_user_mock_response
    override fun statusCode(): Int = 200
}
package com.vortex.soft.sellproducts.data.source.remote.rest.provider.user

import com.vortex.soft.sellproducts.data.repository.user.source.UserRemote
import com.vortex.soft.sellproducts.data.source.remote.dto.user.UserJsonDto
import com.vortex.soft.sellproducts.data.source.remote.rest.common.RestAdapter
import com.vortex.soft.sellproducts.data.source.remote.rest.common.SellProductsAPI
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

class UserRemoteImpl (
        private val apiService: SellProductsAPI,
        private val restAdapter: RestAdapter
) : UserRemote {

    override fun getUser(token: String, userId: Int): Either<FailureType, UserJsonDto> {
        return restAdapter.make(apiService.getUser(token, userId), { it })
    }
}
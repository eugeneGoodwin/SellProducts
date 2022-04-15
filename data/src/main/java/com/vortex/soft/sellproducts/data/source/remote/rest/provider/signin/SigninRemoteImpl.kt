package com.vortex.soft.sellproducts.data.source.remote.rest.provider.signin

import com.vortex.soft.sellproducts.data.repository.signin.source.SigninRemote
import com.vortex.soft.sellproducts.data.source.remote.dto.signin.SigninJsonDto
import com.vortex.soft.sellproducts.data.source.remote.dto.signin.SigninResponseJsonDto
import com.vortex.soft.sellproducts.data.source.remote.rest.common.RestAdapter
import com.vortex.soft.sellproducts.data.source.remote.rest.common.SellProductsAPI
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType


class SigninRemoteImpl (
    private val apiService: SellProductsAPI,
    private val restAdapter: RestAdapter
) : SigninRemote {

    override fun login(signinDto: SigninJsonDto): Either<FailureType, SigninResponseJsonDto> {
        return restAdapter.make(apiService.login(signinDto), { it })
    }
}
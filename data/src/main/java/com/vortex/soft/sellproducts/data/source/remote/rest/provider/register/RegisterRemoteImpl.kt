package com.vortex.soft.sellproducts.data.source.remote.rest.provider.register

import com.vortex.soft.sellproducts.data.repository.register.source.RegisterRemote
import com.vortex.soft.sellproducts.data.source.remote.dto.register.RegisterJsonDto
import com.vortex.soft.sellproducts.data.source.remote.dto.register.RegisterResponseJsonDto
import com.vortex.soft.sellproducts.data.source.remote.rest.common.RestAdapter
import com.vortex.soft.sellproducts.data.source.remote.rest.common.SellProductsAPI
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

class RegisterRemoteImpl (
    private val apiService: SellProductsAPI,
    private val restAdapter: RestAdapter
) : RegisterRemote {

    override fun register(registerDto: RegisterJsonDto): Either<FailureType, RegisterResponseJsonDto> {
        return restAdapter.make(apiService.register(registerDto), { it })
    }
}
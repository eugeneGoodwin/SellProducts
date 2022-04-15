package com.vortex.soft.sellproducts.data.repository.register.source

import com.vortex.soft.sellproducts.data.source.remote.dto.register.RegisterJsonDto
import com.vortex.soft.sellproducts.data.source.remote.dto.register.RegisterResponseJsonDto
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

interface RegisterRemote {
    fun register(registerDto: RegisterJsonDto): Either<FailureType, RegisterResponseJsonDto>
}
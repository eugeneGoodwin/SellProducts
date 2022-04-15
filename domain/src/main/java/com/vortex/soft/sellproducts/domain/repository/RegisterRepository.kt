package com.vortex.soft.sellproducts.domain.repository

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.register.RegisterDto
import com.vortex.soft.sellproducts.domain.dto.register.RegisterResponseDto

interface RegisterRepository {
    fun register(registerDto: RegisterDto): Either<FailureType, RegisterResponseDto>
}
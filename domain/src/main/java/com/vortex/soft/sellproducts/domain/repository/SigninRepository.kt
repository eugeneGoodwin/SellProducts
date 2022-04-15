package com.vortex.soft.sellproducts.domain.repository

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.signin.SigninDto
import com.vortex.soft.sellproducts.domain.dto.signin.SigninResponseDto

interface SigninRepository {
    fun login(signinDto: SigninDto): Either<FailureType, SigninResponseDto>
}
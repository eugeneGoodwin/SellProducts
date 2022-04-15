package com.vortex.soft.sellproducts.data.repository.signin.source

import com.vortex.soft.sellproducts.data.source.remote.dto.signin.SigninJsonDto
import com.vortex.soft.sellproducts.data.source.remote.dto.signin.SigninResponseJsonDto
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

interface SigninRemote {
    fun login(signinDto: SigninJsonDto): Either<FailureType, SigninResponseJsonDto>
}
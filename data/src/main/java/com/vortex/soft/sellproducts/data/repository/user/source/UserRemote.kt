package com.vortex.soft.sellproducts.data.repository.user.source

import com.vortex.soft.sellproducts.data.source.remote.dto.user.UserJsonDto
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

interface UserRemote {
    fun getUser(token: String, userId: Int): Either<FailureType, UserJsonDto>
}
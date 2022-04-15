package com.vortex.soft.sellproducts.domain.repository

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.user.UserDto

interface UserRepository {
    fun getUser(userId: Int): Either<FailureType, UserDto>
}
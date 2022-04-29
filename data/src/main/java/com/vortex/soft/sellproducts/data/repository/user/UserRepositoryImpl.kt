package com.vortex.soft.sellproducts.data.repository.user

import com.vortex.soft.sellproducts.data.mapper.user.UserMapper
import com.vortex.soft.sellproducts.data.repository.common.PreferencesProvider
import com.vortex.soft.sellproducts.data.repository.user.source.UserRemote
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.monad.flatMap
import com.vortex.soft.sellproducts.domain.common.monad.map
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.user.UserDto
import com.vortex.soft.sellproducts.domain.repository.UserRepository

class UserRepositoryImpl(private val remote: UserRemote,
                         private val prefProvider: PreferencesProvider,
                         private val mapper: UserMapper): UserRepository {
    override fun getUser(userId: Int): Either<FailureType, UserDto> {
        return prefProvider.getToken().flatMap { token ->
            remote.getUser(token, userId).map { mapper.mapJsonToDomain(it) }
        }
    }

    override fun getCurrentUserId(): String {
        return prefProvider.getCurrentUserId()
    }

    override fun setCurrentUserId(userid: String) {
        prefProvider.saveCurrentUserId(userid)
    }
}
package com.vortex.soft.sellproducts.data.repository.common

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None


interface PreferencesProvider {
    fun getToken(): Either<FailureType, String>
    fun saveToken(token: String): Either<FailureType, None>
    fun removeToken(): Either<FailureType, None>
    fun getOrderId(): String
    fun saveOrderId(orderId: String)
    fun removeOrderId()
    fun getCurrentUserId(): String
    fun saveCurrentUserId(userId: String)
    fun removeCurrentUserId()
}
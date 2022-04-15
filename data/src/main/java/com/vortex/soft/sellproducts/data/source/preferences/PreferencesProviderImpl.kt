package com.vortex.soft.sellproducts.data.source.preferences

import android.content.SharedPreferences
import com.vortex.soft.sellproducts.data.repository.common.PreferencesProvider
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None

class PreferencesProviderImpl(val prefs: SharedPreferences) : PreferencesProvider {

    override fun getToken(): Either<FailureType, String> {
        return Either.Right(getTokenValue())
    }

    fun getTokenValue(): String {
        return prefs.getString(JWT_TOKEN, "") ?: ""
    }

    override fun saveToken(token: String): Either<FailureType, None> {
        prefs.edit().apply {
            putString(JWT_TOKEN, token)
        }.apply()

        return Either.Right(None())
    }

    override fun removeToken(): Either<FailureType, None> {
        prefs.edit().apply {
            remove(JWT_TOKEN)
        }.apply()

        return Either.Right(None())
    }

    companion object {
        const val JWT_TOKEN = "jwt_token"
    }
}
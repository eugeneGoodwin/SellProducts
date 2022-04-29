package com.vortex.soft.sellproducts.data.repository.launch

import com.vortex.soft.sellproducts.data.repository.common.PreferencesProvider
import com.vortex.soft.sellproducts.data.source.local.database.room.SellProductsDataBase
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.repository.LaunchRepository

class LaunchRepositoryImpl(private val prefProvider: PreferencesProvider,
                           private val sellProductsDB: SellProductsDataBase
): LaunchRepository {
    override fun clearAllData(): Either<FailureType, None> {
        sellProductsDB.clearAllTables()
        prefProvider.removeToken()
        prefProvider.removeOrderId()
        prefProvider.removeCurrentUserId()
        return Either.Right(None())
    }
}
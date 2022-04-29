package com.vortex.soft.sellproducts.domain.interactor.usecases.launch

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.interactor.base.Interactor
import com.vortex.soft.sellproducts.domain.repository.LaunchRepository

class ClearAllDataUseCase ( private val repository: LaunchRepository
) : Interactor<None, None>() {

    override suspend fun run(params: None): Either<FailureType, None> {
        return repository.clearAllData()
    }
}
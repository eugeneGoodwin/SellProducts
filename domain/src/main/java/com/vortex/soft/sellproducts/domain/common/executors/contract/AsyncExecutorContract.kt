package com.vortex.soft.sellproducts.domain.common.executors.contract

import com.vortex.soft.sellproducts.domain.common.executors.Arguments
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType


interface AsyncExecutorContract {

    abstract fun <Input, Output> execute(
        execute: Arguments<Input, Output>,
        params: Input,
        onResult: (Either<FailureType, Output>) -> Unit = {}
    )

    abstract fun terminate()
}

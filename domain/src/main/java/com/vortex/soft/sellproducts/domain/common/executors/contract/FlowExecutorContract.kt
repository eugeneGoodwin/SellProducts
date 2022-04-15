package com.vortex.soft.sellproducts.domain.common.executors.contract

import com.vortex.soft.sellproducts.domain.common.executors.FlowArgument
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType

interface FlowExecutorContract {

    abstract fun <Input, Output> execute(
        function: FlowArgument<Input, Output>,
        params: Input,
        onResult: suspend (Either<FailureType, Output>) -> Unit = {}
    )

    abstract fun terminate()
}
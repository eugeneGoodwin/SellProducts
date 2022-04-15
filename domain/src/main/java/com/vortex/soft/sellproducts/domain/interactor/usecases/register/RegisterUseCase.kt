package com.vortex.soft.sellproducts.domain.interactor.usecases.register

import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.register.RegisterDto
import com.vortex.soft.sellproducts.domain.dto.register.RegisterResponseDto
import com.vortex.soft.sellproducts.domain.interactor.base.Interactor
import com.vortex.soft.sellproducts.domain.repository.RegisterRepository

class RegisterUseCase ( private val repository: RegisterRepository
) : Interactor<RegisterDto, RegisterResponseDto>() {

    override suspend fun run(params: RegisterDto): Either<FailureType, RegisterResponseDto> {
        return repository.register(params)
    }
}
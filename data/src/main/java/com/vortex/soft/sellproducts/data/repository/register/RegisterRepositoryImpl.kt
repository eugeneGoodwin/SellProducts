package com.vortex.soft.sellproducts.data.repository.register

import com.vortex.soft.sellproducts.data.mapper.register.RegisterMapper
import com.vortex.soft.sellproducts.data.mapper.register.RegisterResponseMapper
import com.vortex.soft.sellproducts.data.repository.register.source.RegisterRemote
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.monad.map
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.register.RegisterDto
import com.vortex.soft.sellproducts.domain.dto.register.RegisterResponseDto
import com.vortex.soft.sellproducts.domain.repository.RegisterRepository

class RegisterRepositoryImpl(
    private val remote: RegisterRemote,
    private val mapper: RegisterMapper,
    private val responseMapper: RegisterResponseMapper
): RegisterRepository {

    override fun register(registerDto: RegisterDto): Either<FailureType, RegisterResponseDto> {
        return remote.register(mapper.mapDomainToJson(registerDto)).map { responseMapper.mapJsonToDomain(it) }
    }
}
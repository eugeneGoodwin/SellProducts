package com.vortex.soft.sellproducts.data.repository.signin

import com.vortex.soft.sellproducts.data.mapper.signin.SigninMapper
import com.vortex.soft.sellproducts.data.mapper.signin.SigninResponseMapper
import com.vortex.soft.sellproducts.data.repository.signin.source.SigninRemote
import com.vortex.soft.sellproducts.domain.common.monad.Either
import com.vortex.soft.sellproducts.domain.common.monad.map
import com.vortex.soft.sellproducts.domain.common.type.FailureType
import com.vortex.soft.sellproducts.domain.dto.signin.SigninDto
import com.vortex.soft.sellproducts.domain.dto.signin.SigninResponseDto
import com.vortex.soft.sellproducts.domain.repository.SigninRepository

class SigninRepositoryImpl(
    private val remote: SigninRemote,
    private val mapper: SigninMapper,
    private val responseMapper: SigninResponseMapper
) : SigninRepository {

    override fun login(signinDto: SigninDto): Either<FailureType, SigninResponseDto> {
        return remote.login( mapper.mapDomainToJson(signinDto)).map {
            responseMapper.mapJsonToDomain(it)
        }
    }
}
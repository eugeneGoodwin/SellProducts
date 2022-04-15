package com.vortex.soft.sellproducts.data.mapper.register

import com.vortex.soft.sellproducts.data.mapper.common.JsonMapper
import com.vortex.soft.sellproducts.data.source.remote.dto.register.RegisterJsonDto
import com.vortex.soft.sellproducts.domain.dto.register.RegisterDto

class RegisterMapper : JsonMapper<RegisterDto, RegisterJsonDto> {
    override fun mapDomainToJson(type: RegisterDto): RegisterJsonDto {
        return RegisterJsonDto(
            type.username,
            type.email,
            type.password,
            type.passwordConfirm
        )
    }
    override fun mapJsonToDomain(type: RegisterJsonDto): RegisterDto {
        return RegisterDto(
            type.username,
            type.email,
            type.password,
            type.passwordConfirm
        )
    }
}
package com.vortex.soft.sellproducts.enter.enroll.registration

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.dto.register.RegisterDto
import com.vortex.soft.sellproducts.domain.dto.register.RegisterResponseDto
import com.vortex.soft.sellproducts.domain.interactor.usecases.register.RegisterUseCase

class RegistrationViewModel (val registerUseCase: RegisterUseCase) : BaseViewModel() {

    var registerResponseLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun register(registerDto: RegisterDto) = registerUseCase(registerDto) { it.eitherHandle(::handleFailure, ::handleRegisterResponse) }

    private fun handleRegisterResponse(response: RegisterResponseDto) {
        registerResponseLiveData.value = response.token.isNotEmpty()
    }
}
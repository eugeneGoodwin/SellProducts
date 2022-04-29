package com.vortex.soft.sellproducts.enter.login.signin

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.dto.signin.SigninDto
import com.vortex.soft.sellproducts.domain.dto.signin.SigninResponseDto
import com.vortex.soft.sellproducts.domain.interactor.usecases.signin.SigninUseCase
import com.vortex.soft.sellproducts.domain.interactor.usecases.user.SetCurrentUserIdUseCase

class SigninViewModel(val signinUseCase: SigninUseCase,
                        val setCurrentUserIdUseCase: SetCurrentUserIdUseCase) : BaseViewModel() {

    var signinResponseLiveData: MutableLiveData<SigninResponseDto> = MutableLiveData()

    fun login(signinDto: SigninDto) = signinUseCase(signinDto) { it.eitherHandle(::handleFailure, ::handleSigninResponse) }

    private fun handleSigninResponse(response: SigninResponseDto) {
        signinResponseLiveData.value = response
    }

    fun setCurrentUserId(userId: String) {
        setCurrentUserIdUseCase(userId)
    }
}
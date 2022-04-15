package com.vortex.soft.sellproducts.mainboard.profile

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.dto.user.UserDto
import com.vortex.soft.sellproducts.domain.interactor.usecases.user.GetUserUseCase

class ProfileViewModel (
        val getUserUseCase: GetUserUseCase
) : BaseViewModel() {
    var user: MutableLiveData<UserDto> = MutableLiveData()

    fun getUser(userId: Int) = getUserUseCase(userId) { it.eitherHandle(::handleFailure, ::handleUser) }

    private fun handleUser(userDto: UserDto) {
        user.value = userDto
    }
}
package com.vortex.soft.sellproducts.enter.launch.splash

import androidx.lifecycle.MutableLiveData
import com.vortex.soft.sellproducts.base.presentation.base.BaseViewModel
import com.vortex.soft.sellproducts.domain.common.type.None
import com.vortex.soft.sellproducts.domain.interactor.usecases.launch.ClearAllDataUseCase

class LaunchViewModel (val clearAllDataUseCase: ClearAllDataUseCase
) : BaseViewModel() {

    var clearDataLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun clearData() = clearAllDataUseCase(None()) { it.eitherHandle(::handleFailure, ::handleClearData) }

    private fun handleClearData(none: None) {
        clearDataLiveData.value = true
    }
}
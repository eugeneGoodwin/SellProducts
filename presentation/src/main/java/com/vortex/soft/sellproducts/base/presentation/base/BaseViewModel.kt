package com.vortex.soft.sellproducts.base.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vortex.soft.sellproducts.domain.common.type.FailureType


abstract class BaseViewModel : ViewModel() {

    var failureData: MutableLiveData<FailureType> = MutableLiveData()

    protected fun handleFailure(failure: FailureType) {
        this.failureData.value = failure
    }
}
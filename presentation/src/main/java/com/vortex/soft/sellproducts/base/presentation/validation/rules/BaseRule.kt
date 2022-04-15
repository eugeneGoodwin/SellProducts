package com.vortex.soft.sellproducts.presentation.validation.rules

import com.vortex.soft.sellproducts.presentation.validation.interfaces.ErrorMessage
import com.vortex.soft.sellproducts.presentation.validation.interfaces.Validate

abstract class BaseRule : Validate, ErrorMessage {

    private var errorString: String = ""

    constructor()

    constructor(errorString: String) {
        this.errorString = errorString
    }

    override fun getErrorMessage(): String {
        return errorString
    }
}
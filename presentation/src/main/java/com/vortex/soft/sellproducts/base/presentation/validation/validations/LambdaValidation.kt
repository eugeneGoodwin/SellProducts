package com.vortex.soft.sellproducts.presentation.validation.validations

import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule

class LambdaValidation(val lambda: () -> String, val errorLambda: (String) -> Unit) : Validation() {

    override fun getValue() = lambda()

    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
    }

    override fun setError(error: String) = errorLambda(error)
    override fun clearError() {}
}
package com.vortex.soft.sellproducts.presentation.validation.validations

import android.widget.CheckBox
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.IsCheckedRule

class CheckBoxValidation(val checkBox: CheckBox, val errorListener: (String) -> Unit) : Validation() {

    override fun getValue() = if(checkBox.isChecked) "true" else "false"

    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
    }

    override fun setError(error: String) {
        errorListener(error)
    }

    override fun clearError() {
    }

    fun add(isCheckedRule: IsCheckedRule): CheckBoxValidation {
        super.add(isCheckedRule)
        return this
    }
}
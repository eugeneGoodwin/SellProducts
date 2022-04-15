package com.vortex.soft.sellproducts.presentation.validation.validations

import android.widget.CheckBox
import com.google.android.material.textfield.TextInputLayout
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.IsCheckedRule

class CheckBoxLayoutValidation(val checkBox: CheckBox, val textInputLayout: TextInputLayout) : Validation() {

    override fun getValue() = if(checkBox.isChecked) "true" else "false"
    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
    }

    override fun setError(error: String) {
        textInputLayout.isErrorEnabled = true
        textInputLayout.error = error
    }

    override fun clearError() {
        textInputLayout.error = null
        textInputLayout.isErrorEnabled = false
    }

    fun add(isCheckedRule: IsCheckedRule): CheckBoxLayoutValidation {
        super.add(isCheckedRule)
        return this
    }
}
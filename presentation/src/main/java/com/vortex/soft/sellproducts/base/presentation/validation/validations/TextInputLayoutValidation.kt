package com.vortex.soft.sellproducts.presentation.validation.validations

import android.text.InputFilter
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputLayout
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.clearError
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.turnError
import com.vortex.soft.sellproducts.presentation.validation.conditions.Condition
import com.vortex.soft.sellproducts.presentation.validation.filters.MaxFilter
import com.vortex.soft.sellproducts.presentation.validation.filters.RegexFilter
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.MaxLengthRule
import com.vortex.soft.sellproducts.presentation.validation.rules.regex.RegexRule


class TextInputLayoutValidation(val textInput: AppCompatEditText, val textInputLayout: TextInputLayout) : Validation() {

    override fun getValue() = textInput.text.toString()

    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
    }

    override fun setError(error: String) = textInputLayout.turnError(error)

    override fun clearError() = textInputLayout.clearError()

    fun addRegexRuleWithFilter(regexRule: RegexRule): TextInputLayoutValidation {
        addFilter(RegexFilter(regexRule))
        add(regexRule)
        return this
    }

    fun addMaxLengthRuleWithFilter(maxRule: MaxLengthRule): TextInputLayoutValidation {
        addFilter(MaxFilter(maxRule))
        add(maxRule)
        return this
    }

    private fun addFilter(inputFilter: InputFilter) {
        var filters = textInput.filters.toMutableList()
        filters.add(inputFilter)
        textInput.filters = filters.toTypedArray()
    }

    public override fun add(baseRule: BaseRule): TextInputLayoutValidation { super.add(baseRule); return this }
    public override fun add(condition: Condition): TextInputLayoutValidation { super.add(condition); return this }
}
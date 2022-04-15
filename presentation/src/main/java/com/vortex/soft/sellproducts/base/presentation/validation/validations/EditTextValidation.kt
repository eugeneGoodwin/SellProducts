package com.vortex.soft.sellproducts.presentation.validation.validations

import android.text.InputFilter
import android.widget.EditText
import com.vortex.soft.sellproducts.presentation.validation.conditions.Condition
import com.vortex.soft.sellproducts.presentation.validation.filters.MaxFilter
import com.vortex.soft.sellproducts.presentation.validation.filters.RegexFilter
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.MaxLengthRule
import com.vortex.soft.sellproducts.presentation.validation.rules.regex.RegexRule

class EditTextValidation(val editText: EditText) : Validation() {

    override fun getValue() = editText.text.toString()

    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
    }

    override fun setError(error: String) = editText.setError(error)

    override fun clearError() {
        editText.error = null
    }

    fun addRegexRuleWithFilter(regexRule: RegexRule): EditTextValidation {
        addFilter(RegexFilter(regexRule))
        add(regexRule)
        return this
    }

    fun addMaxLengthRuleWithFilter(maxRule: MaxLengthRule): EditTextValidation {
        addFilter(MaxFilter(maxRule))
        add(maxRule)
        return this
    }

    private fun addFilter(inputFilter: InputFilter) {
        var filters = editText.filters.toMutableList()
        filters.add(inputFilter)
        editText.filters = filters.toTypedArray()
    }

    public override fun add(baseRule: BaseRule): EditTextValidation { super.add(baseRule); return this }
    public override fun add(condition: Condition): EditTextValidation { super.add(condition); return this }
}
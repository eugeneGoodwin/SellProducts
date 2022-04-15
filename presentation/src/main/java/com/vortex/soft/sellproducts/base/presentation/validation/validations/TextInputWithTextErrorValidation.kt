package com.vortex.soft.sellproducts.presentation.validation.validations

import android.text.InputFilter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import com.vortex.soft.sellproducts.presentation.validation.conditions.Condition
import com.vortex.soft.sellproducts.presentation.validation.filters.MaxFilter
import com.vortex.soft.sellproducts.presentation.validation.filters.RegexFilter
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.MaxLengthRule
import com.vortex.soft.sellproducts.presentation.validation.rules.regex.RegexRule

class TextInputWithTextErrorValidation (val textInput: AppCompatEditText, val errorText: TextView) : Validation() {

    override fun getValue() = textInput.text.toString()

    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
    }

    override fun setError(error: String) = errorText.setText(error)

    override fun clearError() = errorText.setText("")

    fun addRegexRuleWithFilter(regexRule: RegexRule): TextInputWithTextErrorValidation {
        addFilter(RegexFilter(regexRule))
        add(regexRule)
        return this
    }

    fun addMaxLengthRuleWithFilter(maxRule: MaxLengthRule): TextInputWithTextErrorValidation {
        addFilter(MaxFilter(maxRule))
        add(maxRule)
        return this
    }

    private fun addFilter(inputFilter: InputFilter) {
        var filters = textInput.filters.toMutableList()
        filters.add(inputFilter)
        textInput.filters = filters.toTypedArray()
    }

    public override fun add(baseRule: BaseRule): TextInputWithTextErrorValidation { super.add(baseRule); return this }
    public override fun add(condition: Condition): TextInputWithTextErrorValidation { super.add(condition); return this }
}
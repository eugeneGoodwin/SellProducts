package com.vortex.soft.sellproducts.presentation.validation.validations

import android.content.Context
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.clearStrikeLine
import com.vortex.soft.sellproducts.base.presentation.tool.extentions.setStrikeLine
import com.vortex.soft.sellproducts.presentation.R
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule
import com.vortex.soft.sellproducts.presentation.validation.rules.common.*

class PasswordValidation(val context: Context,
                         val password: TextInputEditText,
                         val passwordLayout: TextInputLayout,
                         val symbolLenghtLabel: TextView,
                         val lowerCaseLabel: TextView,
                         val upperCaseLabel: TextView,
                         val numbersLabel: TextView
) : Validation() {

    init {
        add(NotEmptyRule(getErrorNoEmptyField("Parole")))
        add(HasDigitRule(getErrorNoFormatField("Parole")))
        add(MinLengthRule(6,"min 6 symbols"))
        add(HasUpperCaseRule(getErrorNoFormatField("Parole")))
        add(HasLowerCaseRule(getErrorNoFormatField("Parole")))
    }

    override fun setRulesWithError(rulesError: ArrayList<BaseRule>) {
        rulesError.filter { it.isErrorAvailable }.firstOrNull()?.let { setError(it.getErrorMessage())}
        rulesError.forEach { setErrorByRule(it) }
    }

    override fun getValue() = password.text.toString()
    override fun setError(error: String) {
        passwordLayout.isErrorEnabled = true
        passwordLayout.error = error
    }

    override fun clearError() {
        passwordLayout.error = null
        passwordLayout.isErrorEnabled = false
        symbolLenghtLabel.setStrikeLine()
        lowerCaseLabel.setStrikeLine()
        upperCaseLabel.setStrikeLine()
        numbersLabel.setStrikeLine()
    }

    private fun setErrorByRule(rule: BaseRule) {
        when(rule) {
            is HasDigitRule -> numbersLabel.clearStrikeLine()
            is MinLengthRule -> symbolLenghtLabel.clearStrikeLine()
            is HasUpperCaseRule -> upperCaseLabel.clearStrikeLine()
            is HasLowerCaseRule -> lowerCaseLabel.clearStrikeLine()
        }
    }

    private fun getErrorNoFormatField(fieldName: String): String {
        return String.format(context.getString(R.string.validate_no_format_field), fieldName)
    }

    private fun getErrorNoEmptyField(fieldName: String): String {
        return String.format(context.getString(R.string.validate_empty_field), fieldName)
    }
}
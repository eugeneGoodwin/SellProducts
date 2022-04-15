package com.vortex.soft.sellproducts.presentation.validation.validations

import com.vortex.soft.sellproducts.presentation.validation.conditions.Condition
import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule

abstract class Validation {

    val baseRules: MutableList<BaseRule> = ArrayList()
    val conditions: MutableList<Condition> = ArrayList()

    abstract fun getValue(): String
    abstract fun setRulesWithError(rulesError: ArrayList<BaseRule>)
    abstract fun setError(error: String)
    abstract fun clearError()

    protected open fun add(baseRule: BaseRule): Validation {
        baseRules.add(baseRule)
        return this
    }

    protected open fun add(condition: Condition): Validation {
        conditions.add(condition)
        return this
    }
}
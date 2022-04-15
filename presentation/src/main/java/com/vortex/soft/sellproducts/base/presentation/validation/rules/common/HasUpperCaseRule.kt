package com.vortex.soft.sellproducts.presentation.validation.rules.common

import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule

class HasUpperCaseRule : BaseRule {

    constructor() : super("Value must not be empty")

    constructor(errorMessage: String) : super(errorMessage)

    override fun validate(value: String?): Boolean {
        if (value == null) {
            throw NullPointerException()
        } else {
            return value.filter { it.isUpperCase() }.firstOrNull()?.let { true } ?: false
        }
    }
}
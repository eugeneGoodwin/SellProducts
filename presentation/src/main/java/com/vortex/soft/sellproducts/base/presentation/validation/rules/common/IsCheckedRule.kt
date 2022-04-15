package com.vortex.soft.sellproducts.presentation.validation.rules.common

import com.vortex.soft.sellproducts.presentation.validation.rules.BaseRule


class IsCheckedRule : BaseRule {

    constructor() : super("Value must be true")

    constructor(errorMessage: String) : super(errorMessage)

    override fun validate(value: String?): Boolean {
        if (value == null) {
            throw NullPointerException()
        } else {
            return (value == "true")
        }
    }
}
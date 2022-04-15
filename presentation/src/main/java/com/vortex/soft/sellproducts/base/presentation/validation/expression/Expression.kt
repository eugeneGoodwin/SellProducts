package com.vortex.soft.sellproducts.presentation.validation.expression

abstract class Expression(val validateExpression: () -> Boolean) {

    fun validate(): Boolean = validateExpression()
}
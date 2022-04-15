package com.vortex.soft.sellproducts.presentation.validation.interfaces

interface ErrorMessage {

    val isErrorAvailable: Boolean
        get() = getErrorMessage().isNotEmpty()

    fun getErrorMessage(): String
}
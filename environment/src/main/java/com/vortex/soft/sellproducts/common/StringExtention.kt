package com.vortex.soft.sellproducts.common

fun String.addJWTPrefix(): String {
    return "Bearer ".plus(this)
}
package com.vortex.soft.sellproducts.di.component

import com.vortex.soft.sellproducts.data.di.component.dataComponent
import com.vortex.soft.sellproducts.domain.di.component.domainComponent
import com.vortex.soft.sellproducts.enter.di.component.enterComponent
import com.vortex.soft.sellproducts.mainboard.di.component.mainboardComponent
import com.vortex.soft.sellproducts.mainboard.di.module.mainboardModule

fun <T> concatenate(vararg lists: List<T>): List<T> {
    return listOf(*lists).flatten()
}

val appComponent = concatenate(dataComponent, domainComponent, enterComponent, mainboardComponent)
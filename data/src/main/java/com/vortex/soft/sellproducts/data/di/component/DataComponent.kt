package com.vortex.soft.sellproducts.data.di.component

import com.vortex.soft.sellproducts.data.di.module.databaseModule
import com.vortex.soft.sellproducts.data.di.module.networkModule
import com.vortex.soft.sellproducts.data.di.module.repositoryModule

val dataComponent = listOf(networkModule, repositoryModule, databaseModule)
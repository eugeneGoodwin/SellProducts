package com.vortex.soft.sellproducts.enter.di.component

import com.vortex.soft.sellproducts.enter.enroll.di.module.enrollModule
import com.vortex.soft.sellproducts.enter.launch.di.launchModule
import com.vortex.soft.sellproducts.enter.login.di.module.signinModule

val enterComponent = listOf(signinModule, enrollModule, launchModule)
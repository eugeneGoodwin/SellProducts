package com.vortex.soft.sellproducts.enter.launch.di

import com.vortex.soft.sellproducts.enter.enroll.EnrollActivity
import com.vortex.soft.sellproducts.enter.enroll.registration.RegistrationFragment
import com.vortex.soft.sellproducts.enter.launch.splash.LaunchViewModel
import com.vortex.soft.sellproducts.enter.launch.splash.SplashActivity
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val launchModule = module {
    viewModel{ LaunchViewModel(get()) }

    scope<SplashActivity> {
    }
}
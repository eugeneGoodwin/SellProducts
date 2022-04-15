package com.vortex.soft.sellproducts.enter.enroll.di.module

import com.vortex.soft.sellproducts.enter.enroll.EnrollActivity
import com.vortex.soft.sellproducts.enter.enroll.registration.RegistrationFragment
import com.vortex.soft.sellproducts.enter.enroll.registration.RegistrationViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val enrollModule = module {
    viewModel{ RegistrationViewModel(get()) }

    scope<EnrollActivity> {
        fragment { RegistrationFragment() }
        scope<RegistrationFragment> {
        }
    }
}
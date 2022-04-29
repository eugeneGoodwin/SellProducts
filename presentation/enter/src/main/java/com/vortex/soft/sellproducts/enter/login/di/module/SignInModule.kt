package com.vortex.soft.sellproducts.enter.login.di.module

import com.vortex.soft.sellproducts.enter.login.LoginActivity
import com.vortex.soft.sellproducts.enter.login.signin.SigninFragment
import com.vortex.soft.sellproducts.enter.login.signin.SigninViewModel
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signinModule = module {
    viewModel{ SigninViewModel(get(), get()) }

    scope<LoginActivity> {
        fragment { SigninFragment() }
        scope<SigninFragment> {
        }
    }
}
package com.vortex.soft.sellproducts.enter.launch.welcome

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.vortex.soft.sellproducts.base.presentation.base.BaseActivity
import com.vortex.soft.sellproducts.common.APP_ENV_COMMON_DATA_KEY
import com.vortex.soft.sellproducts.common.APP_ENV_ENROLL
import com.vortex.soft.sellproducts.common.APP_ENV_LOGIN
import com.vortex.soft.sellproducts.enter.R

class WelcomeActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        openWelcomeFragment()
    }

    fun openWelcomeFragment() {
        val fragment = WelcomeFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.welcomeFragmentContainer, fragment).commit()
    }

    fun toLogin() {
        val data = Intent()
        data.putExtra(APP_ENV_COMMON_DATA_KEY, APP_ENV_LOGIN)
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    fun toRegistration() {
        val data = Intent()
        data.putExtra(APP_ENV_COMMON_DATA_KEY, APP_ENV_ENROLL)
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
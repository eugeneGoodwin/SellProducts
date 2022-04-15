package com.vortex.soft.sellproducts.enter.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.vortex.soft.sellproducts.base.presentation.base.BaseActivity
import com.vortex.soft.sellproducts.common.APP_ENV_COMMON_DATA_KEY
import com.vortex.soft.sellproducts.common.APP_ENV_MAINBOARD
import com.vortex.soft.sellproducts.enter.R


class LoginActivity : BaseActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.loginFragContainer) as NavHostFragment? ?: return
    }

    fun toMainBoard() {
        val data = Intent()
        data.putExtra(APP_ENV_COMMON_DATA_KEY, APP_ENV_MAINBOARD)
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
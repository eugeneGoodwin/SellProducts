package com.vortex.soft.sellproducts.enter.enroll

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.vortex.soft.sellproducts.base.presentation.base.BaseActivity
import com.vortex.soft.sellproducts.common.APP_ENV_COMMON_DATA_KEY
import com.vortex.soft.sellproducts.common.APP_ENV_MAINBOARD
import com.vortex.soft.sellproducts.enter.R

class EnrollActivity : BaseActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.enrollFragContainer) as NavHostFragment? ?: return
    }

    fun toMainBoard() {
        val data = Intent()
        data.putExtra(APP_ENV_COMMON_DATA_KEY, APP_ENV_MAINBOARD)
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}
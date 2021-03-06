package com.vortex.soft.sellproducts.enter.launch.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.vortex.soft.sellproducts.base.presentation.base.BaseActivity
import com.vortex.soft.sellproducts.common.APP_ENV_COMMON_DATA_KEY
import com.vortex.soft.sellproducts.common.APP_ENV_WELCOME
import com.vortex.soft.sellproducts.enter.R
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity() {

    private val splashJob = Job()
    private val splashScope = CoroutineScope(Dispatchers.Main + splashJob)

    private val launchViewModel: LaunchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_splash)
        initializeViewModel()
        launchViewModel.clearData()
    }

    fun initializeViewModel() {
        launchViewModel.clearDataLiveData.observe(this, Observer<Boolean> { isAllClear ->
            splashScope.launch {
                delay(SPLASH_TIME_OUT)
                toWelcome()
            }
        })
    }

    private fun toWelcome() {
        val data = Intent()
        data.putExtra(APP_ENV_COMMON_DATA_KEY, APP_ENV_WELCOME)
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    public override fun onDestroy() {
        splashScope.cancel()
        super.onDestroy()
    }

    companion object {
        private const val APP_REQUEST_CODE_SPLASH = 0x2356
        private const val SPLASH_TIME_OUT: Long = 3000
    }
}
package com.vortex.soft.sellproducts.controller

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vortex.soft.sellproducts.common.*
import com.vortex.soft.sellproducts.enter.enroll.EnrollActivity
import com.vortex.soft.sellproducts.enter.launch.splash.SplashActivity
import com.vortex.soft.sellproducts.enter.launch.welcome.WelcomeActivity
import com.vortex.soft.sellproducts.enter.login.LoginActivity
import com.vortex.soft.sellproducts.mainboard.MainboardActivity

class RootControllerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toLaunch()
    }

    private fun toLaunch() {
        val intent = Intent(applicationContext, SplashActivity::class.java)
        Intent.FLAG_ACTIVITY_NO_ANIMATION
        Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        Intent.FLAG_ACTIVITY_CLEAR_TASK
        Intent.FLAG_ACTIVITY_NO_HISTORY
        startActivityForResult(intent, APP_REQUEST_ROOT_ACTIVITY)
    }

    private fun toEnroll() {
        val intent = Intent(this@RootControllerActivity, EnrollActivity::class.java)
        startActivityForResult(intent, APP_REQUEST_ROOT_ACTIVITY)
    }

    private fun toWelcome() {
        val intent = Intent(this@RootControllerActivity, WelcomeActivity::class.java)
        startActivityForResult(intent, APP_REQUEST_ROOT_ACTIVITY)
    }

    private fun toLogin() {
        val intent = Intent(this@RootControllerActivity, LoginActivity::class.java)
        startActivityForResult(intent, APP_REQUEST_ROOT_ACTIVITY)
    }

    private fun toMainboard(str: String) {
        val intent = Intent(this@RootControllerActivity, MainboardActivity::class.java)
        intent.putExtra(APP_ENV_COMMON_DATA_KEY,str)
        startActivityForResult(intent, APP_REQUEST_ROOT_ACTIVITY)
        //startActivity(intent)
        //finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        val result = intent?.getStringExtra(APP_ENV_COMMON_DATA_KEY)
        if (requestCode == APP_REQUEST_ROOT_ACTIVITY) {
            handleRequestCode(resultCode, result)
        } else throw Exception("Failed attempt to Intent result! Check correct parameter passing to intent")
    }

    private fun handleRequestCode(resultCode: Int, result: String?) = when (resultCode) {
        Activity.RESULT_OK -> {
            navigateHandler(result)
        }
        Activity.RESULT_CANCELED -> {
            finish()
        }
        else -> {
            //startActivity(Intent(this@RootControllerActivity, FailureActivity::class.java))
            finish()
        }
    }

    private fun navigateHandler(result: String?) {
        when (result) {
            APP_ENV_WELCOME -> toWelcome()
            APP_ENV_LOGIN -> toLogin()
            APP_ENV_ENROLL -> toEnroll()
            APP_ENV_MAINBOARD -> toMainboard(result)
            else -> {
                finish()
            }
        }
    }

    companion object {
        private val APP_REQUEST_ROOT_ACTIVITY = 0x7900
    }
}
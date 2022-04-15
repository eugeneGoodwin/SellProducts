package com.vortex.soft.sellproducts.base.presentation.base

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vortex.soft.sellproducts.presentation.R
import kotlin.reflect.KClass

abstract class BaseActivity: AppCompatActivity() {
    fun showToast(message: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(
            this,
            message ?: "Null",
            duration
        ).show()
    }

    fun  onAlertExitApp(cls: KClass<out Activity>, s: String, s1: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage(/*""*/s1)
            .setCancelable(false)
            .setPositiveButton(getString(R.string.alert_exit_app_confirm), DialogInterface.OnClickListener { dialog, id ->
                // finish()
                finishAffinity();
            })
            .setNegativeButton(getString(R.string.alert_exit_app_deny), DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        dialogBuilder.create().apply {
            setTitle(s)
            show()
        }
    }
}
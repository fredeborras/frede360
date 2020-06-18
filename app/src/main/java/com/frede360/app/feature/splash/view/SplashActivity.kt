package com.frede360.app.feature.splash.view

import android.os.Bundle
import com.frede360.app.commons.view.Frede360BaseActivity
import com.frede360.app.feature.login.view.LoginActivity

class SplashActivity : Frede360BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        goLogin()
    }

    private fun goLogin() {
        Thread.sleep(500)
        launchActivity(LoginActivity())
        finish()
    }
}
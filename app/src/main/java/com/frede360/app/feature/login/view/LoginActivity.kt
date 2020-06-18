package com.frede360.app.feature.login.view

import android.os.Bundle
import com.frede360.app.R
import com.frede360.app.commons.view.Frede360BaseActivity

class LoginActivity : Frede360BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
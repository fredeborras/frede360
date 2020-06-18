package com.frede360.app.feature.register.view

import android.os.Bundle
import com.frede360.app.R
import com.frede360.app.commons.view.Frede360BaseActivity

class RegisterActivity : Frede360BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun backButtonEnabled() = true
}
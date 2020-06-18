package com.frede360.app.feature.login.view

import android.os.Bundle
import android.view.View
import com.frede360.app.R
import com.frede360.app.commons.utils.Frede360TextUtils
import com.frede360.app.commons.view.Frede360BaseViewModelActivity
import com.frede360.app.feature.login.viewmodel.LoginViewModel
import com.frede360.app.feature.register.view.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : Frede360BaseViewModelActivity<LoginViewModel>() {

//  ====================================
//  LifeCycle
//  ====================================

    override fun getViewModelClass(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureView()
    }

    override fun configureView() {
        super.configureView()

        loginBtn.setOnButtonClicked(View.OnClickListener {
            if (checkFields()) {
                launchLogin()
            }
        })

        registerBtn.setOnClickListener { launchActivity(RegisterActivity()) }
    }

//  ====================================
//  Private methods
//  ====================================

    /**
     * Called to check if login fields are valid:
     * - Valid email
     * - Password between 6 and 12 chars
     */
    private fun checkFields(): Boolean {
        if (mailField.text.toString().isEmpty()) {
            mailField.error = getString(R.string.error_email_empty)

            return false
        }
        if (!Frede360TextUtils.isValidEmail(mailField.text.toString())) {
            mailField.error = getString(R.string.error_email_invalid)

            return false
        }
        if (!Frede360TextUtils.isValidPwd(pwdField.text.toString())) {
            pwdField.error = getString(R.string.error_pwd_invalid)

            return false
        }

        return true
    }

    private fun launchLogin() {

    }
}
package com.frede360.app.feature.register.view

import android.os.Bundle
import android.view.View
import com.frede360.app.R
import com.frede360.app.commons.hideKeyboard
import com.frede360.app.commons.utils.Frede360TextUtils
import com.frede360.app.commons.view.Frede360BaseViewModelActivity
import com.frede360.app.feature.register.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : Frede360BaseViewModelActivity<RegisterViewModel>() {

//  ====================================
//  LifeCycle
//  ====================================

    override fun getViewModelClass(): Class<RegisterViewModel> {
        return RegisterViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        configureView()
    }

    override fun backButtonEnabled() = true

    override fun configureView() {
        super.configureView()

        signUpBtn.setOnButtonClicked(View.OnClickListener {
            if (checkFields()) {
                hideKeyboard()
                launchRegister()
            }
        })
    }

//  ====================================
//  Private methods
//  ====================================

    /**
     * Called to check if register fields are valid:
     * - Valid email
     * - Password between 6 and 12 chars
     * - Age between 18 and 99 years old
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

        if (ageField.text.toString().toInt() !in 18..99) {
            ageField.error = getString(R.string.error_age_invalid)
            return false
        }

        return true
    }

    private fun launchRegister() {
        //TODO
    }

}
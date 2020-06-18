package com.frede360.app.commons.utils

import android.text.TextUtils

class Frede360TextUtils {

    companion object {
        fun isValidEmail(target: CharSequence): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }
        }

        fun isValidPwd(pwd: String) = pwd.length in 6..12
    }
}
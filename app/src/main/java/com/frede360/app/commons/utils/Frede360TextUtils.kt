package com.frede360.app.commons.utils

import android.text.TextUtils
import kotlin.math.abs

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

        fun formatCoolNumber(value: Long?): String {
            if (value != null) {
                return when {
                    abs(value / 1000000) > 1 -> {
                        (value / 1000000).toString() + "m."
                    }
                    abs(value / 1000) > 1 -> {
                        (value / 1000).toString() + "k."
                    }
                    else -> {
                        value.toString()
                    }
                }
            }

            return "0"
        }
    }
}
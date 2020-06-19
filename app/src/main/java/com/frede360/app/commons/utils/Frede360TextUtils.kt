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

        fun formatByteNumber(bytes: Long?) = when {
            bytes == Long.MIN_VALUE || bytes == null || bytes < 0 -> "N/A"
            bytes < 1024L -> "$bytes B"
            bytes <= 0xfffccccccccccccL shr 40 -> "%.1f KiB".format(bytes.toDouble() / (0x1 shl 10))
            bytes <= 0xfffccccccccccccL shr 30 -> "%.1f MiB".format(bytes.toDouble() / (0x1 shl 20))
            bytes <= 0xfffccccccccccccL shr 20 -> "%.1f GiB".format(bytes.toDouble() / (0x1 shl 30))
            bytes <= 0xfffccccccccccccL shr 10 -> "%.1f TiB".format(bytes.toDouble() / (0x1 shl 40))
            bytes <= 0xfffccccccccccccL -> "%.1f PiB".format((bytes shr 10).toDouble() / (0x1 shl 40))
            else -> "%.1f EiB".format((bytes shr 20).toDouble() / (0x1 shl 40))
        }
    }
}
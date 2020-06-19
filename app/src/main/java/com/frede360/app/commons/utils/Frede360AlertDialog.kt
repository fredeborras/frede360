package com.frede360.app.commons.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.frede360.app.Frede360Application
import com.frede360.app.R

class Frede360AlertDialog {

    interface OnSimpleAlertDialogClickListener {
        fun onPositiveBtnClicked()
    }

    companion object {

        fun default(msg: String) {
            val context = Frede360Application.activityContext
            context?.let {
                show(
                    it,
                    it.getString(R.string.generic_attention),
                    msg,
                    it.getString(android.R.string.ok),
                    object : OnSimpleAlertDialogClickListener {
                        override fun onPositiveBtnClicked() {}
                    })
            }
        }

        fun show(
            context: Context,
            title: String,
            msg: String,
            positiveBtnText: String,
            callback: OnSimpleAlertDialogClickListener
        ) {
            val builder = AlertDialog.Builder(context)
            builder.setCancelable(false)
            builder.setTitle(title)
            builder.setMessage(msg)
            builder.setPositiveButton(positiveBtnText) { _, _ -> callback.onPositiveBtnClicked() }
            builder.show()
        }
    }
}
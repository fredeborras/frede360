package com.frede360.app.commons.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.frede360.app.R

class Frede360AlertDialog {

    interface OnSimpleAlertDialogClickListener {
        fun onPositiveBtnClicked()
    }

    companion object {

        fun default(context: Context?, msg: String) {
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

        fun basic(
            context: Context,
            title: String,
            msg: String,
            callback: OnSimpleAlertDialogClickListener
        ) {
            show(context, title, msg, context.getString(android.R.string.ok), callback)
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
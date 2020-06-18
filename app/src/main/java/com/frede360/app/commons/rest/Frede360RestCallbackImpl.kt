package com.frede360.app.commons.rest

import android.content.Context
import com.frede360.app.R
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.utils.Frede360AlertDialog

/**
 * Frede360RestCallbackImpl handles each connection to centralize default behaviours
 */
open class Frede360RestCallbackImpl(private val context: Context) : Frede360RestCallback {

    override fun onSuccess(response: SuccessEntity) {
        //TODO: Hide loader
    }

    override fun onError(error: ErrorEntity) {
        //TODO: Hide loader
        if (error.message.isEmpty()) {
            error.message = context.getString(R.string.error_connection)
        }

        Frede360AlertDialog.default(context, error.message)
    }

}
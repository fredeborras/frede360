package com.frede360.app.commons.rest

import com.frede360.app.Frede360Application
import com.frede360.app.R
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.utils.Frede360AlertDialog

class Frede360RestErrorManager {

    companion object {
        fun showErrorDialog(error: ErrorEntity) {
            if (error.message.isEmpty()) {
                Frede360Application.activityContext?.let {
                    error.message = it.getString(R.string.error_connection)
                }
            }

            Frede360AlertDialog.default(error.message)
        }
    }

}
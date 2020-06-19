package com.frede360.app.commons.rest

import com.frede360.app.commons.manager.Frede360LoaderManager
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity

/**
 * Frede360RestCallbackImpl handles each connection to centralize default behaviours
 */
open class Frede360RestCallbackImpl : Frede360RestCallback {

    override fun onSuccess(response: SuccessEntity) {
        Frede360LoaderManager.hide()
    }

    override fun onError(error: ErrorEntity) {
        Frede360LoaderManager.hide()
        Frede360RestErrorManager.showErrorDialog(error)
    }

}
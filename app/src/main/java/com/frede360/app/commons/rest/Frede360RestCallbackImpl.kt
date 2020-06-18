package com.frede360.app.commons.rest

import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity

/**
 * Frede360RestCallbackImpl handles each connection to centralize default behaviours
 */
open class Frede360RestCallbackImpl : Frede360RestCallback {

    override fun onSuccess(response: SuccessEntity) {
        //TODO: Hide loader
    }

    override fun onError(error: ErrorEntity) {
        //TODO: Hide loader and show default message
    }

}
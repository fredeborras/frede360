package com.frede360.app.commons.rest

import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity

interface Frede360RestCallback {
    /**
     * Called when the connection has been successfully
     */
    fun onSuccess(response: SuccessEntity)

    /**
     * Called when the connection has failed
     */
    fun onError(error: ErrorEntity)
}
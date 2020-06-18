package com.frede360.app.commons.rest.local

import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import java.lang.Exception

/**
 * Frede360LocalCallbackImpl is responsible of getting the response after reading a local json.
 *
 * Moreover Frede360LocalCallbackImpl creates view entities (SuccessEntity - ErrorEntity) depending on result behaviour
 */
open class Frede360LocalCallbackImpl<E>(private val callback: Frede360RestCallback) :
    Frede360LocalCallback<E> {

    override fun onLocalSuccess(response: E) {
        val success = SuccessEntity()
        success.body = response

        callback.onSuccess(success)
    }

    override fun onLocalError(e: Exception) {
        val error = ErrorEntity()
        e.message?.let {
            error.message = it
        }

        callback.onError(error)
    }
}
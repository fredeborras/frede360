package com.frede360.app.commons.rest.local

import java.lang.Exception

interface Frede360LocalCallback<E> {
    /**
     * Called when json is read correctly
     */
    fun onLocalSuccess(response: E)

    /**
     * Called when there is an error reading json
     */
    fun onLocalError(e: Exception)
}
package com.frede360.app.feature.login.repository

import com.frede360.app.commons.rest.Frede360BaseRepository
import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.Frede360RestConstants
import com.frede360.app.commons.rest.local.Frede360LocalCallbackImpl
import com.frede360.app.feature.login.entities.LoginOut

class LoginRepository : Frede360BaseRepository() {

//  ====================================
//  Params
//  ====================================

    private val loginJson = "backend/login.json"
    var username = ""

    private object HOLDER {
        val INSTANCE = LoginRepository()
    }

//  ====================================
//  Public methods
//  ====================================

    companion object {
        val instance: LoginRepository by lazy { HOLDER.INSTANCE }
    }

    fun launchLogin(callback: Frede360RestCallback) {
        enqueueJsonData(loginJson, object : Frede360LocalCallbackImpl<LoginOut>(callback) {

            override fun onLocalSuccess(response: LoginOut) {
                //Check "status" param value before executing callback
                if (response.status == Frede360RestConstants.success) {
                    saveUsername(response.data.username)

                    super.onLocalSuccess(response)
                } else {
                    val e = Exception(response.messageError)
                    onLocalError(e)
                }
            }

        })
    }

    /**
     * Called to save username value in LoginRepository
     */
    fun saveUsername(name: String) {
        if (name.isNotEmpty()) {
            username = name
        }
    }

}
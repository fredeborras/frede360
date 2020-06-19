package com.frede360.app.feature.register.repository

import com.frede360.app.commons.rest.Frede360BaseRepository
import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.Frede360RestConstants
import com.frede360.app.commons.rest.local.Frede360LocalCallbackImpl
import com.frede360.app.feature.login.repository.LoginRepository
import com.frede360.app.feature.register.entities.RegisterOut

class RegisterRepository : Frede360BaseRepository() {

//  ====================================
//  Params
//  ====================================

    private val registerJson = "backend/register.json"

//  ====================================
//  Public methods
//  ====================================

    fun launchRegister(callback: Frede360RestCallback) {
        enqueueJsonData(registerJson, object : Frede360LocalCallbackImpl<RegisterOut>(callback) {

            override fun onLocalSuccess(response: RegisterOut) {
                //Check "status" param value before executing callback
                if (response.status == Frede360RestConstants.success) {
                    //Save username in LoginRepository
                    LoginRepository.instance.saveUsername(response.data.username)

                    super.onLocalSuccess(response)
                } else {
                    val e = Exception(response.messageError)
                    onLocalError(e)
                }
            }

        })
    }
}
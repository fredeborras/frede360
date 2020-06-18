package com.frede360.app.feature.register.repository

import android.content.Context
import com.frede360.app.commons.rest.Frede360BaseRepository
import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.Frede360RestConstants
import com.frede360.app.commons.rest.local.Frede360LocalCallbackImpl
import com.frede360.app.commons.utils.SingletonHolder
import com.frede360.app.feature.login.entities.LoginOut
import com.frede360.app.feature.login.repository.LoginRepository
import java.lang.Exception

class RegisterRepository constructor(override val context: Context) : Frede360BaseRepository(context) {

//  ====================================
//  Params
//  ====================================

    private val registerJson = "backend/register_ok.json"

//  ====================================
//  Public methods
//  ====================================

    companion object : SingletonHolder<RegisterRepository, Context>(::RegisterRepository)

    fun launchRegister(callback: Frede360RestCallback) {
        enqueueJsonData(registerJson, object : Frede360LocalCallbackImpl<LoginOut>(callback) {

            override fun onLocalSuccess(response: LoginOut) {
                //Check "status" param value before executing callback
                if (response.status == Frede360RestConstants.success) {
                    //Save username in LoginRepository
                    LoginRepository.getInstance(context).saveUsername(response)

                    super.onLocalSuccess(response)
                } else {
                    val e = Exception(response.messageError)
                    onLocalError(e)
                }
            }

        })
    }
}
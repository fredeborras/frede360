package com.frede360.app.feature.login.repository

import android.content.Context
import com.frede360.app.commons.rest.Frede360BaseRepository
import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.Frede360RestConstants
import com.frede360.app.commons.rest.local.Frede360LocalCallbackImpl
import com.frede360.app.commons.utils.SingletonHolder
import com.frede360.app.feature.login.entities.LoginOut
import java.lang.Exception

class LoginRepository constructor(override val context: Context) : Frede360BaseRepository(context) {

//  ====================================
//  Params
//  ====================================

    private val loginJson = "backend/login_ok.json"
    var username = ""

//  ====================================
//  Public methods
//  ====================================

    companion object : SingletonHolder<LoginRepository, Context>(::LoginRepository)

    fun launchLogin(callback: Frede360RestCallback) {
        enqueueJsonData(loginJson, object : Frede360LocalCallbackImpl<LoginOut>(callback) {

            override fun onLocalSuccess(response: LoginOut) {
                //Check "status" param value before executing callback
                if (response.status == Frede360RestConstants.success) {
                    saveUsername(response)

                    super.onLocalSuccess(response)
                } else {
                    val e = Exception(response.messageError)
                    onLocalError(e)
                }
            }

        })
    }

//  ====================================
//  Private methods
//  ====================================

    /**
     * Called to save username value in LoginRepository
     */
    private fun saveUsername(loginData: LoginOut) {
        username = loginData.data.username
    }

}
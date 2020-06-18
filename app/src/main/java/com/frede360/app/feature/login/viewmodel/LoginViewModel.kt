package com.frede360.app.feature.login.viewmodel

import androidx.lifecycle.MutableLiveData
import com.frede360.app.commons.rest.Frede360RestCallbackImpl
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel
import com.frede360.app.feature.login.repository.LoginRepository

class LoginViewModel : Frede360BaseViewModel() {

    private lateinit var loginResponse: MutableLiveData<Boolean>

    fun launchLogin(): MutableLiveData<Boolean> {
        loginResponse = MutableLiveData()

        LoginRepository.getInstance(context).launchLogin(object : Frede360RestCallbackImpl() {
            override fun onSuccess(response: SuccessEntity) {
                super.onSuccess(response)

                loginResponse.value = true
            }

            override fun onError(error: ErrorEntity) {
                super.onError(error)

                loginResponse.value = false
            }
        })

        return loginResponse
    }


}
package com.frede360.app.feature.register.viewmodel

import androidx.lifecycle.MutableLiveData
import com.frede360.app.commons.rest.Frede360RestCallbackImpl
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel
import com.frede360.app.feature.register.repository.RegisterRepository

class RegisterViewModel : Frede360BaseViewModel() {

    private lateinit var registerResponse: MutableLiveData<Boolean>

    fun launchRegister(): MutableLiveData<Boolean> {
        registerResponse = MutableLiveData()

        RegisterRepository().launchRegister(object : Frede360RestCallbackImpl() {
                override fun onSuccess(response: SuccessEntity) {
                    super.onSuccess(response)

                    registerResponse.value = true
                }
            })

        return registerResponse
    }
}
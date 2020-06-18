package com.frede360.app.feature.register.viewmodel

import androidx.lifecycle.MutableLiveData
import com.frede360.app.commons.rest.Frede360RestCallbackImpl
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel
import com.frede360.app.feature.register.repository.RegisterRepository

class RegisterViewModel : Frede360BaseViewModel() {

    private lateinit var registerResponse: MutableLiveData<Boolean>

    fun launchRegister(): MutableLiveData<Boolean> {
        registerResponse = MutableLiveData()

        RegisterRepository.getInstance(context)
            .launchRegister(object : Frede360RestCallbackImpl(context) {
                override fun onSuccess(response: SuccessEntity) {
                    super.onSuccess(response)

                    registerResponse.value = true
                }

                override fun onError(error: ErrorEntity) {
                    super.onError(error)

                    registerResponse.value = false
                }
            })

        return registerResponse
    }
}
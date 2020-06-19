package com.frede360.app.feature.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.frede360.app.commons.rest.Frede360RestCallbackImpl
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel
import com.frede360.app.feature.login.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel : Frede360BaseViewModel() {

    private lateinit var loginResponse: MutableLiveData<Boolean>

    fun launchLogin(): MutableLiveData<Boolean> {
        loginResponse = MutableLiveData()

        viewModelScope.launch {
            LoginRepository.instance.launchLogin(object : Frede360RestCallbackImpl() {
                override fun onSuccess(response: SuccessEntity) {
                    super.onSuccess(response)

                    loginResponse.value = true
                }
            })
        }

        return loginResponse
    }
}
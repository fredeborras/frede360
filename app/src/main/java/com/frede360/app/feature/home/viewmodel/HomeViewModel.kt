package com.frede360.app.feature.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.frede360.app.commons.rest.Frede360RestCallbackImpl
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel
import com.frede360.app.feature.home.entities.PixabayImagesIn
import com.frede360.app.feature.home.entities.PixabayImagesOut
import com.frede360.app.feature.home.repository.HomeRepository
import com.frede360.app.feature.login.repository.LoginRepository

class HomeViewModel : Frede360BaseViewModel() {

    private lateinit var pixabayResponse: MutableLiveData<PixabayImagesOut>

    fun launchPixabayImages(): MutableLiveData<PixabayImagesOut> {
        pixabayResponse = MutableLiveData()

        //Init values by default
        val pixabayIn = PixabayImagesIn()
        pixabayIn.key = "17111786-e5d5d4c6e2e59c875a9ab3e5f"
        pixabayIn.q = "yellow flowers"
        pixabayIn.imageType = "photo"
        pixabayIn.pretty = true

        HomeRepository(context).launchPixabayImages(
            pixabayIn,
            object : Frede360RestCallbackImpl(context) {
                override fun onSuccess(response: SuccessEntity) {
                    super.onSuccess(response)

                    pixabayResponse.value = response.body as PixabayImagesOut
                }

                override fun onError(error: ErrorEntity) {
                    //Change behaviour on error to avoid showing error dialog
                    pixabayResponse.value = null
                }
            })

        return pixabayResponse
    }
}
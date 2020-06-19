package com.frede360.app.feature.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.frede360.app.commons.rest.Frede360RestCallbackImpl
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel
import com.frede360.app.feature.home.entities.PixabayImagesIn
import com.frede360.app.feature.home.entities.PixabayImagesOut
import com.frede360.app.feature.home.repository.HomeRepository

class HomeViewModel : Frede360BaseViewModel() {

    private lateinit var pixabayResponse: MutableLiveData<PixabayImagesOut>

    fun launchPixabayImages(): MutableLiveData<PixabayImagesOut> {
        pixabayResponse = MutableLiveData()

        //Init values by default
        val pixabayIn = PixabayImagesIn()
        pixabayIn.key = "17111786-e5d5d4c6e2e59c875a9ab3e5f"
        pixabayIn.q = "world"
        pixabayIn.imageType = "photo"
        pixabayIn.pretty = true

        HomeRepository().launchPixabayImages(
            pixabayIn,
            object : Frede360RestCallbackImpl() {
                override fun onSuccess(response: SuccessEntity) {
                    super.onSuccess(response)

                    pixabayResponse.value = response.body as PixabayImagesOut
                }

                override fun onError(error: ErrorEntity) {
                    //Changing behaviour on error to avoid showing the default error dialog
                    pixabayResponse.value = null
                }
            })

        return pixabayResponse
    }
}
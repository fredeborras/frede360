package com.frede360.app.feature.home.repository

import android.content.Context
import com.frede360.app.commons.rest.Frede360BaseRepository
import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.retrofit.Frede360RetrofitCallbackImpl
import com.frede360.app.feature.home.datasource.HomeDataSource
import com.frede360.app.feature.home.entities.PixabayImagesIn
import com.frede360.app.feature.home.entities.PixabayImagesOut

class HomeRepository constructor(override val context: Context) : Frede360BaseRepository(context) {

    private val dataSource = getDataSource(HomeDataSource::class.java)

    fun launchPixabayImages(pixabayIn: PixabayImagesIn, callback: Frede360RestCallback) {
        dataSource.pixabayImages(pixabayIn.key, pixabayIn.q, pixabayIn.imageType, pixabayIn.pretty)
            .enqueue(object : Frede360RetrofitCallbackImpl<PixabayImagesOut>(callback) {})
    }
}
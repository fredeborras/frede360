package com.frede360.app.feature.home.datasource

import com.frede360.app.feature.home.entities.PixabayImagesOut
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDataSource {
    @GET("api")
    fun pixabayImages(
        @Query("key") key: String?,
        @Query("q") q: String?,
        @Query("image_type") imageType: String?,
        @Query("pretty") pretty: Boolean?
    ): Call<PixabayImagesOut>

}
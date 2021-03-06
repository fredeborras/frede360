package com.frede360.app.feature.home.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PixabayImagesIn : Serializable {
    @Expose
    var key: String? = null
    @Expose
    var q: String? = null
    @SerializedName("image_type")
    var imageType: String? = null
    @Expose
    var pretty: Boolean = false
}
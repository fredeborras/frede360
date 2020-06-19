package com.frede360.app.feature.home.entities

import com.google.gson.annotations.Expose
import java.io.Serializable

class PixabayImagesOut : Serializable {
    @Expose
    var hits: List<Hit>? = null
    @Expose
    var total: Long? = null
    @Expose
    var totalHits: Long? = null

}
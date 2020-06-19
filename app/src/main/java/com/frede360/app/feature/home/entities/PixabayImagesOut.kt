package com.frede360.app.feature.home.entities

import com.google.gson.annotations.Expose

class PixabayImagesOut {
    @Expose
    var hits: List<Hit>? = null
    @Expose
    var total: Long? = null
    @Expose
    var totalHits: Long? = null

}
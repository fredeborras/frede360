package com.frede360.app.feature.home.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hit {
    @Expose
    var comments: Long? = null
    @Expose
    var downloads: Long? = null
    @Expose
    var favorites: Long? = null
    @Expose
    var id: Long? = null
    @Expose
    var imageHeight: Long? = null
    @Expose
    var imageSize: Long? = null
    @Expose
    var imageWidth: Long? = null
    @Expose
    var largeImageURL: String? = null
    @Expose
    var likes: Long? = null
    @Expose
    var pageURL: String? = null
    @Expose
    var previewHeight: Long? = null
    @Expose
    var previewURL: String? = null
    @Expose
    var previewWidth: Long? = null
    @Expose
    var tags: String? = null
    @Expose
    var type: String? = null
    @Expose
    var user: String? = null
    @SerializedName("user_id")
    var userId: Long? = null
    @Expose
    var userImageURL: String? = null
    @Expose
    var views: Long? = null
    @Expose
    var webformatHeight: Long? = null
    @Expose
    var webformatURL: String? = null
    @Expose
    var webformatWidth: Long? = null

}
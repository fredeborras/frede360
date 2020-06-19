package com.frede360.app.feature.register.entities

import com.google.gson.annotations.Expose
import java.io.Serializable

class RegisterOut : Serializable {
    @Expose
    var status = ""
    @Expose
    var messageError = ""
    @Expose
    var data = RegisterData()

    class RegisterData : Serializable {
        @Expose
        var username = ""
    }
}
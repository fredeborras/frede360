package com.frede360.app.feature.login.entities

import com.google.gson.annotations.Expose
import java.io.Serializable

class LoginOut : Serializable {
    @Expose
    var status = ""
    @Expose
    var messageError = ""
    @Expose
    var data = LoginData()

    class LoginData : Serializable {
        @Expose
        var username = ""
    }
}
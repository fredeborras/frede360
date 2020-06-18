package com.frede360.app.feature.login.entities

class LoginOut {
    var status = ""
    var messageError = ""
    var data = LoginData()

    class LoginData {
        var username = ""
    }
}
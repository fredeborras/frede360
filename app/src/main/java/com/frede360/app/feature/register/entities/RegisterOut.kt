package com.frede360.app.feature.register.entities

class RegisterOut {
    var status = ""
    var messageError = ""
    var data = RegisterData()

    class RegisterData {
        var username = ""
    }
}
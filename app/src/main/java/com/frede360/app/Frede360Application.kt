package com.frede360.app

import android.app.Application
import com.frede360.app.commons.view.Frede360BaseActivity

class Frede360Application : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: Frede360Application? = null
        var activityContext: Frede360BaseActivity? = null
    }
}
package com.frede360.app.commons.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel

/**
 * Frede360BaseViewModel centralize base behaviours of all Frede360 View Models
 */
open class Frede360BaseViewModel : ViewModel() {

    lateinit var context: Context
}
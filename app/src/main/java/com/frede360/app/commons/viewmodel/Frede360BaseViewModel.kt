package com.frede360.app.commons.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel

open class Frede360BaseViewModel : ViewModel() {

    lateinit var context: Context //FIXME: No necessary -> migrate singleton creation with Dagger
}
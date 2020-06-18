package com.frede360.app.commons.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel

abstract class Frede360BaseViewModelActivity<VM : Frede360BaseViewModel> : Frede360BaseActivity() {

    protected lateinit var viewModel: VM

    abstract fun getViewModelClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[getViewModelClass()]
    }
}
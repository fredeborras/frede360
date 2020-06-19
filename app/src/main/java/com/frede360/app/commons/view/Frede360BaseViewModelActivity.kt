package com.frede360.app.commons.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.frede360.app.commons.viewmodel.Frede360BaseViewModel

/**
 * Frede360BaseViewModelActivity centralize base behaviours of all Frede 360 Activities with View Model
 */
abstract class Frede360BaseViewModelActivity<VM : Frede360BaseViewModel> : Frede360BaseActivity() {

//  ====================================
//  Params
//  ====================================

    /**
     * View Model of current Activity
     */
    protected lateinit var viewModel: VM

//  ====================================
//  LifeCycle
//  ====================================

    /**
     * Return View Model of current Activity
     */
    abstract fun getViewModelClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[getViewModelClass()]
        viewModel.context = this
    }
}
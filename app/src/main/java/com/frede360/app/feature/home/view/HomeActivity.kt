package com.frede360.app.feature.home.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.frede360.app.commons.view.Frede360BaseViewModelActivity
import com.frede360.app.feature.home.viewmodel.HomeViewModel

class HomeActivity : Frede360BaseViewModelActivity<HomeViewModel>() {

    override fun getViewModelClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configureView()
    }

    override fun configureView() {
        super.configureView()

        launchPixabayImages()
    }

    private fun launchPixabayImages() {
        viewModel.launchPixabayImages().observe(this, Observer {
            if (it != null) {
                buildPixabayImageList()
            } else {
                showEmptyState()
            }
        })
    }

    /**
     * Main function to build the list of Pixabay images
     */
    private fun buildPixabayImageList() {
        //TODO
    }

    /**
     * Show empty state if there is an error on request or if list of image is empty
     */
    private fun showEmptyState() {
        //TODO
    }

}
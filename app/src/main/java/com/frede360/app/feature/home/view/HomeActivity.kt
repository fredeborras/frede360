package com.frede360.app.feature.home.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.frede360.app.R
import com.frede360.app.commons.view.Frede360BaseViewModelActivity
import com.frede360.app.feature.home.entities.Hit
import com.frede360.app.feature.home.entities.PixabayImagesOut
import com.frede360.app.feature.home.view.adapter.HomePixabayImageAdapter
import com.frede360.app.feature.home.view.adapter.OnPixabayImageClickedListener
import com.frede360.app.feature.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : Frede360BaseViewModelActivity<HomeViewModel>(), OnPixabayImageClickedListener {

    override fun getViewModelClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        configureView()
    }

    override fun configureView() {
        super.configureView()

        launchPixabayImages()
    }

    private fun launchPixabayImages() {
        viewModel.launchPixabayImages().observe(this, Observer {
            if (it != null) {
                buildPixabayImageList(it)
            } else {
                showEmptyState()
            }
        })
    }

    /**
     * Main function to build the list of Pixabay images
     */
    private fun buildPixabayImageList(response: PixabayImagesOut) {
        pixabayRecyclerView.visibility = VISIBLE
        emptyView.visibility = GONE

        if (response.hits != null && response.hits!!.isNotEmpty()) {
            val adapter = HomePixabayImageAdapter(response.hits!!, this)
            pixabayRecyclerView.layoutManager = GridLayoutManager(this, 2)
            pixabayRecyclerView.adapter = adapter
        } else {
            showEmptyState()
        }
    }

    override fun onPixabayImageClicked(item: Hit) {
        //TODO
    }

    /**
     * Show empty state if there is an error on request or if list of image is empty
     */
    private fun showEmptyState() {
        pixabayRecyclerView.visibility = GONE
        emptyView.visibility = VISIBLE
    }

}
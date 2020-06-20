package com.frede360.app.feature.home.view

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.frede360.app.R
import com.frede360.app.commons.manager.Frede360LoaderManager
import com.frede360.app.commons.view.Frede360BaseViewModelActivity
import com.frede360.app.feature.home.entities.Hit
import com.frede360.app.feature.home.entities.PixabayImagesOut
import com.frede360.app.feature.home.view.HomeImageDetailActivity.Companion.imageDetailExtra
import com.frede360.app.feature.home.view.adapter.HomePixabayImageAdapter
import com.frede360.app.feature.home.view.adapter.OnPixabayImageClickedListener
import com.frede360.app.feature.home.viewmodel.HomeViewModel
import com.frede360.app.feature.login.repository.LoginRepository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : Frede360BaseViewModelActivity<HomeViewModel>(), OnPixabayImageClickedListener {

//  ====================================
//  LifeCycle
//  ====================================

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

        //Configure action title
        val homeTitle = LoginRepository.instance.username
        if (homeTitle.isNotEmpty()) {
            title = homeTitle
        }

        configureRefreshSwipeLayout()

        Frede360LoaderManager.show()
        launchPixabayImages()
    }

//  ====================================
//  RefreshSwipeLayout methods
//  ====================================

    private fun configureRefreshSwipeLayout() {
        swipeRefreshLayout.setOnRefreshListener {
            launchPixabayImages()
        }
    }

    private fun hideSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

//  ====================================
//  Other private methods
//  ====================================

    /**
     * Called to launch request to Pixabay to get images
     */
    private fun launchPixabayImages() {
        viewModel.launchPixabayImages().observe(this, Observer {
            hideSwipeRefresh()

            if (it != null) {
                buildPixabayImageList(it)
            } else {
                Frede360LoaderManager.hide()
                showEmptyState()
            }
        })
    }

    /**
     * Main function to build list of Pixabay images
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
        val intent = Intent(this, HomeImageDetailActivity::class.java)
        intent.putExtra(imageDetailExtra, item)
        launchActivity(intent)
    }

    /**
     * Show empty state if there is an error on request or if list of image is empty
     */
    private fun showEmptyState() {
        pixabayRecyclerView.visibility = GONE
        emptyView.visibility = VISIBLE
    }

}
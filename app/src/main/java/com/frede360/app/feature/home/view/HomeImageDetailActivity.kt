package com.frede360.app.feature.home.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frede360.app.R
import com.frede360.app.commons.utils.Frede360ImageUtils
import com.frede360.app.commons.utils.Frede360TextUtils
import com.frede360.app.commons.view.Frede360BaseActivity
import com.frede360.app.feature.home.entities.Hit
import com.frede360.app.feature.home.view.adapter.TagsAdapter
import kotlinx.android.synthetic.main.activity_home_image_detail.*
import kotlinx.android.synthetic.main.container_collapsing_image.*
import kotlinx.android.synthetic.main.container_image_info.*

class HomeImageDetailActivity : Frede360BaseActivity() {

//  ====================================
//  Params
//  ====================================

    companion object {
        const val imageDetailExtra = "image_extra"
    }

    private lateinit var imageDetail: Hit

//  ====================================
//  LifeCycle
//  ====================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_image_detail)

        //Get extras before configuring view
        val bundle: Bundle? = intent.extras
        bundle?.let {
            it.get(imageDetailExtra)?.let { extra ->
                this.imageDetail = extra as Hit

                configureView()
            }
        }
    }

    override fun backButtonEnabled() = true

    override fun configureView() {
        super.configureView()

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = ""
        }

        buildImageSection()
        buildDetailSection()
    }

//  ====================================
//  Private methods
//  ====================================

    private fun buildImageSection() {
        Glide.with(this)
            .load(this.imageDetail.largeImageURL)
            .placeholder(R.color.generic_grey_light)
            .into(image)

        //Build size and type
        imageSizeLabel.text = getString(
            R.string.image_size,
            Frede360TextUtils.formatByteNumber(this.imageDetail.imageSize)
        )
        imageTypeLabel.text = getString(
            R.string.image_type,
            Frede360ImageUtils.getMimeType(this.imageDetail.largeImageURL)
        )

        //Build tag list
        val tagsList = this.imageDetail.tags?.split(",")
        if (tagsList != null && tagsList.isNotEmpty()) {
            val adapter = TagsAdapter(tagsList)
            tagsRecyclerView.layoutManager =
                LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
            tagsRecyclerView.adapter = adapter
        }
    }

    private fun buildDetailSection() {
        user.text = this.imageDetail.user
        views.text = Frede360TextUtils.formatCoolNumber(this.imageDetail.views)
        likes.text = Frede360TextUtils.formatCoolNumber(this.imageDetail.likes)
        comments.text = Frede360TextUtils.formatCoolNumber(this.imageDetail.comments)
        favorites.text = Frede360TextUtils.formatCoolNumber(this.imageDetail.favorites)
        downloads.text = Frede360TextUtils.formatCoolNumber(this.imageDetail.downloads)
    }
}
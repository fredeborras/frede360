package com.frede360.app.feature.home.view

import android.os.Bundle
import com.bumptech.glide.Glide
import com.frede360.app.R
import com.frede360.app.commons.view.Frede360BaseActivity
import com.frede360.app.feature.home.entities.Hit
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.android.synthetic.main.activity_home_image_detail.*

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

        Glide.with(this)
            .load(this.imageDetail.largeImageURL)
            .placeholder(R.color.generic_grey_light)
            .into(image)

        user.text = this.imageDetail.user
        views.text = this.imageDetail.views.toString()
        likes.text = this.imageDetail.likes.toString()
        comments.text = this.imageDetail.comments.toString()
        favorites.text = this.imageDetail.favorites.toString()
        downloads.text = this.imageDetail.downloads.toString()
    }
}
package com.frede360.app.feature.home.view.adapter

import com.frede360.app.feature.home.entities.Hit

interface OnPixabayImageClickedListener {

    /**
     * Called when a Pixabay image is clicked
     */
    fun onPixabayImageClicked(item: Hit)

}
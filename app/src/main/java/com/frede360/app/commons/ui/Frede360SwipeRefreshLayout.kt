package com.frede360.app.commons.ui

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.frede360.app.R

class Frede360SwipeRefreshLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : SwipeRefreshLayout(context, attrs) {

    init {
        setColorSchemeResources(R.color.colorAccent)
        setProgressBackgroundColorSchemeResource(android.R.color.white)
    }
}
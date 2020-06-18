package com.frede360.app.commons.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.frede360.app.R
import kotlinx.android.synthetic.main.view_frede360_button.view.*

class Frede360Button @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_frede360_button, this, true)

        orientation = HORIZONTAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.Frede360Button, 0, 0)

            val title = typedArray.getString(R.styleable.Frede360Button_frede360_text)
            val enabled = typedArray.getBoolean(R.styleable.Frede360Button_frede360_enabled, true)

            button.text = title
            button.isEnabled = enabled

            typedArray.recycle()
        }
    }

    fun setOnFrede360ButtonClicked(listener: OnClickListener) {
        button.setOnClickListener(listener)
    }
}
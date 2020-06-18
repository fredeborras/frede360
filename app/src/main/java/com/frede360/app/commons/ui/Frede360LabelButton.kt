package com.frede360.app.commons.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.frede360.app.R
import kotlinx.android.synthetic.main.view_frede360_label_button.view.*

class Frede360LabelButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_frede360_label_button, this, true)

        orientation = HORIZONTAL

        attrs?.let {
            val typedArray =
                context.obtainStyledAttributes(it, R.styleable.Frede360LabelButton, 0, 0)

            val title = typedArray.getString(R.styleable.Frede360LabelButton_frede360_text)
            val textColor = resources.getInteger(
                typedArray.getResourceId(
                    R.styleable.Frede360LabelButton_frede360_color,
                    R.color.colorPrimary
                )
            )

            mainLabel.text = title
            mainLabel.setTextColor(textColor)

            typedArray.recycle()
        }
    }

}
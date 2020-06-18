package com.frede360.app.commons

import android.view.inputmethod.InputMethodManager
import com.frede360.app.commons.view.Frede360BaseActivity

fun Frede360BaseActivity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm =
            getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
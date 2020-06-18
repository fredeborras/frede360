package com.frede360.app.commons.manager

import android.content.Intent
import com.frede360.app.commons.view.Frede360BaseActivity
import com.frede360.app.feature.home.view.HomeActivity

/**
 * Frede360NavigationManager centralizes the most important navigations of Frede360
 */
class Frede360NavigationManager {

    companion object {

        /**
         * Navigate to Home cleaning all previous Activities
         */
        fun goHome(activity: Frede360BaseActivity) {
            val intent = Intent(activity, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            activity.launchActivity(intent)
            activity.finish()
        }
    }
}
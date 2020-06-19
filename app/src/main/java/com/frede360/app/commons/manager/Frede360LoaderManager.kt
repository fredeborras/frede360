package com.frede360.app.commons.manager

import android.util.Log
import com.frede360.app.commons.view.Frede360BaseActivity
import com.frede360.app.commons.view.Frede360LoaderFragment
import java.lang.Exception

class Frede360LoaderManager {

    companion object {

        private val tag: String = Frede360LoaderManager::class.java.toString()

        fun show(activity: Frede360BaseActivity) {
            show(activity, android.R.id.content)
        }

        fun show(activity: Frede360BaseActivity, id: Int) {
            try {
                //If there is a loader in the current activity, delete it before showing other
                if (isLoaderVisible(activity)) {
                    hide(activity)
                }

                Thread(Runnable {
                    activity.runOnUiThread {
                        val manager = activity.supportFragmentManager

                        val transaction = manager.beginTransaction()
                        val fragment = Frede360LoaderFragment()
                        fragment.containerID = id
                        transaction.add(id, fragment, tag)
                        transaction.commit()
                    }
                }).start()
            } catch (e: Exception) {
                Log.e(tag, e.toString(), e)
            }
        }

        fun hide(activity: Frede360BaseActivity) {
            try {
                Thread(Runnable {
                    activity.runOnUiThread {
                        val manager = activity.supportFragmentManager
                        val fragment = manager.findFragmentByTag(tag)

                        val transaction = manager.beginTransaction()
                        fragment?.let {
                            transaction.remove(it)
                            transaction.commitAllowingStateLoss()
                        }
                    }
                }).start()
            } catch (e: Exception) {
                Log.e(tag, e.toString(), e)
            }
        }

        fun isLoaderVisible(activity: Frede360BaseActivity): Boolean {
            val manager = activity.supportFragmentManager
            val fragment = manager.findFragmentByTag(tag)

            return fragment != null && fragment is Frede360LoaderFragment
        }
    }
}
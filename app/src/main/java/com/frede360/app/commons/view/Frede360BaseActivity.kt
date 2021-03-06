package com.frede360.app.commons.view

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.frede360.app.Frede360Application

@SuppressLint("Registered")
open class Frede360BaseActivity : AppCompatActivity() {

//  ====================================
//  LifeCycle
//  ====================================

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Force Portrait to all Activities
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        Frede360Application.activityContext = this
        configureBackButton(backButtonEnabled())
    }

    override fun onResume() {
        super.onResume()

        Log.i("onResume: ", this.javaClass.name)
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("onDestroy: ", this.javaClass.name)
    }

//  ====================================
//  Override methods
//  ====================================

    override fun finish() {
        super.finish()

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Show back button if true
     */
    open fun backButtonEnabled() = false

    /**
     * Main method to configure view
     */
    open fun configureView() {
        //Nothing to do by default
    }

//  ====================================
//  Public methods
//  ====================================

    /**
     * Main Frede360 method to startActivity
     */
    fun launchActivity(activity: AppCompatActivity) {
        val intent = Intent(this, activity::class.java)
        launchActivity(intent)
    }

    fun launchActivity(intent: Intent) {
        val bundle = ActivityOptions.makeCustomAnimation(
            this,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        ).toBundle()

        startActivity(intent, bundle)
    }

//  ====================================
//  Private methods
//  ====================================

    private fun configureBackButton(enabled: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(enabled)
    }
}
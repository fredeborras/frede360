package com.frede360.app.commons.rest.local

import android.content.Context
import android.util.Log

class Frede360LocalClient {

    companion object {

        private val tag = Frede360LocalClient::class.java.toString()

        fun getJson(context: Context, fileName: String): String {
            var jsonString = ""
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (e: Exception) {
                Log.e(tag, e.toString(), e)
            }

            return jsonString
        }
    }
}
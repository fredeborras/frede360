package com.frede360.app.commons.rest

import android.content.Context
import com.frede360.app.Frede360Application
import com.frede360.app.commons.rest.local.Frede360LocalCallback
import com.frede360.app.commons.rest.local.Frede360LocalClient
import com.google.gson.GsonBuilder
import java.lang.Exception

open class Frede360BaseRepository {

    var context: Context = Frede360Application.activityContext!!

    /**
     * Called to get the DataSource of current Repository
     */
    inline fun <reified REPO> getDataSource(repo: Class<REPO>): REPO {
        return Frede360DataSource.instance.getDataSource(repo)!!
    }

    /**
     * Called to get data from json using entity specified (E)
     */
    inline fun <reified E> enqueueJsonData(fileName: String, callback: Frede360LocalCallback<E>) {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        //Get Json file as String
        val json = Frede360LocalClient.getJson(this.context, fileName)

        //Read Json data
        try {
            val response = gson.fromJson(json, E::class.java)
            callback.onLocalSuccess(response)
        } catch (e: Exception) {
            callback.onLocalError(e)
        }
    }
}
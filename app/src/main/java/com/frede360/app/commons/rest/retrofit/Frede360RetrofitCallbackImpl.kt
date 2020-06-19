package com.frede360.app.commons.rest.retrofit

import android.util.Log
import com.frede360.app.commons.rest.Frede360RestCallback
import com.frede360.app.commons.rest.entities.ErrorEntity
import com.frede360.app.commons.rest.entities.SuccessEntity
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

open class Frede360RetrofitCallbackImpl<E>(private val callback: Frede360RestCallback?) : Callback<E> {

    private var tag: String? = Frede360RetrofitCallbackImpl::class.java.name

    override fun onFailure(call: Call<E>, t: Throwable) {
        val error = ErrorEntity()
        error.error = t.cause.toString()
        error.message = t.message.toString()

        callback?.onError(error)
    }

    override fun onResponse(call: Call<E>, response: Response<E>) {
        if (response.isSuccessful) {
            val success = SuccessEntity()
            success.body = response.body()

            callback?.onSuccess(success)
        } else {
            var error = ErrorEntity()
            try {
                error =
                    Gson().fromJson(response.errorBody()!!.charStream(), ErrorEntity::class.java)
            } catch (e: Exception) {
                Log.e(tag, e.toString(), e)
            }

            callback?.onError(error)
        }
    }
}
package com.frede360.app.commons.rest

import com.frede360.app.commons.utils.Frede360Constants.PIXABAY_URL

class Frede360DataSource {

    companion object {
        val instance = Frede360DataSource()
    }

    inline fun <reified T> getDataSource(dataSource: Class<T>): T? {
        return Frede360HttpClient.instance.getClient(PIXABAY_URL).create(dataSource)
    }
}
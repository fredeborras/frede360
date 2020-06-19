package com.frede360.app.commons.utils

import android.webkit.MimeTypeMap

class Frede360ImageUtils {

    companion object {
        fun getMimeType(url: String?): String? {
            var type: String? = null
            val extension = MimeTypeMap.getFileExtensionFromUrl(url)

            if (extension != null) {
                type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
            }

            return type
        }
    }
}
package org.android.aui.backend.storage

import android.content.Context
import android.content.SharedPreferences

/**
 * LocalStorage
 *
 * A local storage for the application.
 * ```kotlin
 * LocalStorage.put("<name>", "<data>")
 *
 * LocalStorage.get("<name>")
 * ```
 *
 * LocalStorage stores data in a shared
 * preference - **data**
 */
object LocalStorage {
    /**
     * Storage Instance
     */
    private lateinit var storage: SharedPreferences



    /**
     * Initializes the [LocalStorage], this is called
     * once in the [RootLayout][org.android.aui.layouts.RootLayout]
     * and should therefore not be called *manually*.
     */
    fun init(context: Context) {
        storage = context.getSharedPreferences("android-ui data", Context.MODE_PRIVATE)
    }



    /**
     * Puts value into ```LocalStorage```
     */
    fun put(name: String, data: String) {
        storage.edit().putString(name, data).apply()
    }



    /**
     * Gets value from ```LocalStorage```
     */
    fun get(name: String) : String? {
        return storage.getString(name, null)
    }
}

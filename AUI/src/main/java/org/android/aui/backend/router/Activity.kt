package org.android.aui.backend.router

import android.content.Context
import android.view.Window
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext
import org.android.aui.layouts.RootLayout

/**
 * Local Window Context
 */
private val localWindow = compositionLocalOf<Window> {
    error("No Activity Provider Present in the Layout")
}



/**
 * Activity Provider
 */
@Composable
fun ActivityProvider(activity: RootLayout, children: @Composable () -> Unit) {
    CompositionLocalProvider(localWindow provides activity.window) {
        children()
    }
}





/**
 * Window State
 */
@Composable
fun useWindow(): Window = localWindow.current

/**
 * Context State
 */
@Composable
fun useContext(): Context = LocalContext.current

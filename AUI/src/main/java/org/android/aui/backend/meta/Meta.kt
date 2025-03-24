package org.android.aui.backend.meta

import androidx.compose.runtime.Composable
import org.android.aui.backend.pages.Error
import org.android.aui.backend.pages.StarterPage

/**
 * Layout Metadata
 */
data class Meta (
    /**
     * Weather or not to use fullscreen
     */
    val fullscreen: Boolean = false,
    /**
     * Weather or not to use Edge to Edge
     */
    val edgeToEdge: Boolean = true,

    /**
     * The Application Page Routing
     */
    val routing: HashMap<String, @Composable () -> Unit> = HashMap<String, @Composable () -> Unit>().apply {
        put("home") { StarterPage() }
    },

    /**
     * Application Starter Page
     */
    val start: @Composable () -> Unit = { StarterPage() },

    /**
     * Application Page Loading Fallback Page
     */
    val fallback: @Composable () -> Unit = { Error() },
)

package org.android.ui.backend.meta

import androidx.compose.runtime.Composable
import org.android.ui.backend.pages.StarterPage

/**
 * Layout Metadata
 */
data class Meta (
    /**
     * Weather or not to use fullscreen
     */
    val fullscreen: Boolean = false,

    /**
     * The Application Starter Page
     */
    val startPage: @Composable () -> Unit = { StarterPage() }
)

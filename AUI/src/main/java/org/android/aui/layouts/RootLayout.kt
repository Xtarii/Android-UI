package org.android.aui.layouts

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import org.android.aui.backend.hooks.ActivityEvent
import org.android.aui.backend.hooks.ActivityEventsManager
import org.android.aui.backend.meta.Meta
import org.android.aui.backend.router.ActivityProvider
import org.android.aui.backend.router.RouterProvider
import org.android.aui.backend.router.useRouter
import org.android.aui.backend.storage.LocalStorage

/**
 * Abstract Root Layout
 */
abstract class RootLayout(private val metadata: Meta = Meta()) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if(metadata.edgeToEdge) enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        if(metadata.fullscreen) hideSystemUI() // Hides Navigation UI
        val route: String? = intent.getStringExtra("route")

        LocalStorage.init(this) // Creates local storage for this activity

        onSetup() // Setup
        setContent { // Layout Content
            ActivityProvider(this@RootLayout) {
                RouterProvider(metadata.routing, metadata.start, metadata.fallback) {
                    val router = useRouter()
                    if(route != null) router.setLocation(route) // Loads Route Page as current

                    Layout {
                        router.Current()
                    }
                }
            }
        }
    }



    /**
     * Setup method
     *
     * This is used to setup layout
     * and application settings.
     */
    abstract fun onSetup()

    /**
     * Layout Component
     *
     * This is where the application
     * UI and layout should be set.
     */
    @Composable
    abstract fun Layout(children: @Composable () -> Unit)





    /**
     * Hides System UI
     *
     * This will hide the System Navigation
     * and put application in fullscreen.
     */
    @Suppress("DEPRECATION")
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )
    }





    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        ActivityEventsManager.broadcast(ActivityEvent.CONFIGURATION, newConfig)
    }

    override fun onResume() {
        super.onResume()
        ActivityEventsManager.broadcast(ActivityEvent.RESUME, Unit)
    }

    override fun onPause() {
        super.onPause()
        ActivityEventsManager.broadcast(ActivityEvent.PAUSE, Unit)
    }
}

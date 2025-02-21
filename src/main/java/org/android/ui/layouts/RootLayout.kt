package org.android.ui.layouts

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import org.android.ui.backend.meta.Meta
import org.android.ui.backend.router.RouterProvider
import org.android.ui.backend.router.useRouter

/**
 * Abstract Root Layout
 */
abstract class RootLayout(private val metadata: Meta = Meta()) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        if(metadata.fullscreen) hideSystemUI() // Hides Navigation UI

        onSetup() // Setup
        setContent { // Layout Content
            RouterProvider {
                val router = useRouter()
                Layout {
                    router.Current()
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
}

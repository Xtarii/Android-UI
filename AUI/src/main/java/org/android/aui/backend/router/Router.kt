package org.android.aui.backend.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Router Component
 *
 * This provides a way to switch
 * and use pages in one activity.
 *
 * Can be used to provide a global
 * layout for the application over
 * many different pages.
 */
@Stable
class Router(
    /**
     * Page Routing Map
     */
    private val routing: HashMap<String, @Composable () -> Unit>,

    /**
     * Starting Page
     */
    private val start: @Composable () -> Unit,
    /**
     * Fallback Page
     */
    private val fallback: @Composable () -> Unit,
) {
    /**
     * Current Router Page
     */
    private var _current by mutableStateOf<(@Composable () -> Unit)>(start)


    /**
     * Current Router Page
     *
     * This will give the current page
     * set in the router.
     */
    @Composable
    fun Current() { _current.invoke() }



    /**
     * Sets Application Location to the provided page
     */
    fun setLocation(page: @Composable () -> Unit) { _current = page }
    /**
     * Sets Application Location to the provided page route
     */
    fun setLocation(page: String) { _current = routing[page] ?: fallback }
    /**
     * Sets Application Location to the ```starter``` page
     */
    fun setLocation() { _current = start }

    /**
     * Sets Application Location to the ```fallback``` Page
     */
    fun error() { _current = fallback }
}





/**
 * Local Router Context
 */
private val localRouter = compositionLocalOf<Router> {
    error("No router provided for the current context. Use RouterProvider to use the router.")
}



/**
 * Router Provider
 *
 * This provider provides the router
 * context.
 *
 * In order to use the router this
 * must be set as a parent in the
 * application activity over the
 * other components.
 */
@Composable
fun RouterProvider(routing: HashMap<String, @Composable () -> Unit>, start: @Composable () -> Unit, fallback: @Composable () -> Unit, children: @Composable () -> Unit) {
    val router = remember { Router(routing, start, fallback) }
    CompositionLocalProvider(localRouter provides router) {
        children()
    }
}



/**
 * Router Context
 *
 * This will return the current
 * router context present in the
 * application root layout.
 *
 * ##### Note,
 * there must be a ```RouterProvider```
 * present in the application layout.
 * ```kt
 * @Composable
 * /// Application Layout
 * RouterProvider {
 *      /// Application Layout goes here.
 * }
 * ```
 * If the activity uses the ```RootLayout```
 * the ```RouterProvider``` is already set
 * and no extra work is needed.
 *
 *
 * ##### Examples
 * ```kt
 * @Composable
 * /// code
 *
 * val router = useRouter()
 * router.setLocation { MyPage() } // Where my page is a composable unit
 * ```
 */
@Composable
fun useRouter(): Router {
    return localRouter.current
}

package org.android.aui.backend.hooks

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import java.lang.ref.WeakReference

/**
 * Activity Event
 */
enum class ActivityEvent(var value: String) {
    /**
     * Resume Event
     */
    RESUME("resume"),
    /**
     * Pause Event
     */
    PAUSE("pause"),

    /**
     * Configuration Change Event
     *
     * Events of this type sends
     * the [Configuration] parameter
     */
    CONFIGURATION("configuration"),
}



/**
 * Activity Event Manager
 *
 * Handles and broadcasts activity
 * events to its subscribers.
 */
object ActivityEventsManager {
    /**
     * Event Subscribers
     */
    private val subscribers = mutableMapOf<String, MutableSet<WeakReference<(Any?) -> Unit>>>()



    /**
     * Subscribes to Activity Event
     */
    fun<T> subscribe(event: ActivityEvent, listener: (T) -> Unit) { subscribers.getOrPut(event.value){ mutableSetOf() }.add(
        WeakReference{ param -> (param as? T)?.let(listener) })
    }

    /**
     * Unsubscribe from Activity Event
     *
     * This is done automatically by the event handler
     */
    fun<T> unsubscribe(event: ActivityEvent, listener: (T) -> Unit) { subscribers[event.value]?.removeIf{
        val ref = it.get()
        ref == null || ref === listener
    }}



    /**
     * Broadcasts Activity Event
     */
    fun broadcast(event: ActivityEvent, param: Any?) {
        subscribers[event.value]?.removeIf { it.get() == null }
        subscribers[event.value]?.forEach { it.get()?.invoke(param) }
    }
}





/**
 * On Event Subscriber
 *
 * This is used to subscribe to the
 * activity events from.
 *
 * #### Note,
 * the event callback is automatically
 * removed when it is not needed.
 */
@Composable
inline fun<reified T> onEvent(event: ActivityEvent, noinline callback: (T) -> Unit): Int {
    val current by rememberUpdatedState(callback)
    DisposableEffect(Unit) {
        ActivityEventsManager.subscribe(event, current)
        onDispose { ActivityEventsManager.unsubscribe(event, current) }
    }
    return 0 // Indicates no error
}

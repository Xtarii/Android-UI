package org.android.aui.styles.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

/**
 * Theme State
 */
@Stable
class ThemeState(theme: Theme) {
    /**
     * Theme State
     */
    private var state by mutableStateOf(theme)



    /**
     * Theme Dark Mode
     */
    var dark get() = state.dark
        set(value) { state = state.copy(dark = value) }

    /**
     * Theme Background Color
     */
    val background get() = state.getBackground()



    /**
     * Gets Theme Color set by color set name
     */
    fun getColorSet(color: ThemeKeysType): ThemeColorSet { return state.getColorSet(color) }

    /**
     * Gets Color of theme set
     *
     * If dark mode is set to true
     * the dark color is returned,
     * else the light mode is returned.
     */
    fun getColor(color: ThemeKeysType): Color { return state.getColor(color) }
}



/**
 * Local Theme Context
 */
private val localTheme = compositionLocalOf { ThemeState(Theme()) }



/**
 * Theme Provider
 *
 * A provider for the application theme.
 */
@Composable
fun ThemeProvider(theme: Theme = Theme(dark = isSystemInDarkTheme()), children: @Composable () -> Unit = {}) {
    val state = remember { ThemeState(theme) }
    CompositionLocalProvider(localTheme provides state) {
        children()
    }
}



/**
 * Application Theme State
 */
@Composable
fun useTheme(): ThemeState {
    return localTheme.current
}

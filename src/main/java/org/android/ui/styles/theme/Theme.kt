package org.android.ui.styles.theme

import androidx.compose.ui.graphics.Color

/**
 * Theme Color Set
 */
data class ThemeColorSet (
    /**
     * Light Color value
     */
    val lightColor: Color,
    /**
     * Dark Color value
     */
    val darkColor: Color,
)



/**
 * Theme Data Class
 */
data class Theme (
    /**
     * Theme Dark Mode
     */
    var dark: Boolean = false,



    /**
     * Theme Background Color
     */
    val background: ThemeColorSet = ThemeColorSet(
        lightColor = Color(0xFFD5D4DE),
        darkColor = Color(0xFF2F2F34)
    ),

    /**
     * Fallback Color set
     *
     * If a color set is not found
     * this can be used as a fallback.
     */
    val fallbackColorSet: ThemeColorSet = ThemeColorSet(
        lightColor = Color(0xFF24A0FF),
        darkColor = Color(0xFF2382CD)
    ),



    /**
     * Theme colors set
     */
    private val colors: HashMap<String, ThemeColorSet> = HashMap<String, ThemeColorSet>().apply {
        // Main Colors
        put("primary", ThemeColorSet(
            lightColor = Color(0xFF24A0FF),
            darkColor = Color(0xFF2382CD)
        ))
        put("success", ThemeColorSet(
            lightColor = Color(0xFFA4E86D),
            darkColor = Color(0xFF6E9E2F)
        ))
        put("background", ThemeColorSet(
            lightColor = Color(0xFFCBCBCB),
            darkColor = Color(0xFF423F3F)
        ))


        // Text Colors
        put("text", ThemeColorSet(
            lightColor = Color(0xFF000000),
            darkColor = Color(0xFFAAA6A6)
        ))
        put("dark text", ThemeColorSet(
            lightColor = Color(0xFF000000),
            darkColor = Color(0xFF282525)
        ))
    },
) {
    /**
     * Gets Theme Color set by color set name
     */
    fun getColorSet(color: String): ThemeColorSet { return colors[color] ?: fallbackColorSet }

    /**
     * Gets Color of theme set
     *
     * If dark mode is set to true
     * the dark color is returned,
     * else the light mode is returned.
     */
    fun getColor(color: String): Color {
        val colorSet = getColorSet(color)
        return if(dark) colorSet.darkColor
        else colorSet.lightColor
    }



    /**
     * Gets Theme Background Color
     */
    fun getBackground(): Color { return if(dark) background.darkColor else background.lightColor }
}

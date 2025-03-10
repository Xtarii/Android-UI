package org.android.ui.styles.text

import androidx.compose.ui.text.input.KeyboardType

/**
 * Text Style Data Class
 */
data class TextStyle(
    /**
     * Text Size
     */
    val textSize: Float = 1f,

    /**
     * Text Multiline
     */
    val multiline: Boolean = false,
    /**
     * Maximum Number of Text Lines
     */
    val maxLines: Int = 1,

    /**
     * Text Input Type
     */
    val keyboardType: KeyboardType = KeyboardType.Text,
    /**
     * Readonly Text
     */
    val readonly: Boolean = false,
)

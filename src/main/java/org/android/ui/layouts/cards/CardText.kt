package org.android.ui.layouts.cards

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.android.ui.styles.Style
import org.android.ui.text.Typography

/**
 * Default Card Text Style
 */
val DefaultCardTextStyle: Style = Style(
    margin = PaddingValues(start = 12.dp, top = 4.dp),
)



/**
 * Card Component Text
 *
 * This is a different Component
 * from the title
 */
@Composable
fun CardText(text: String, style: Style = DefaultCardTextStyle, color: String = "text") {
    Typography(text, style = style, color = color)
}

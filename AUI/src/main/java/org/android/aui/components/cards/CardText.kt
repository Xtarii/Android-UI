package org.android.aui.components.cards

import androidx.compose.runtime.Composable
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.components.text.Typography

/**
 * Card Component Text
 *
 * This is a different Component
 * from the title
 */
@Composable
fun CardText(text: String, style: Style = DefaultStyles.Clickable.Cards.text, color: String = "text") {
    Typography(text, style = style, color = color)
}

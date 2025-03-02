package org.android.ui.components.cards

import androidx.compose.runtime.Composable
import org.android.ui.styles.DefaultStyles
import org.android.ui.styles.Style
import org.android.ui.text.Typography

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

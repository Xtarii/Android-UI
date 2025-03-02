package org.android.ui.components.cards

import androidx.compose.runtime.Composable
import org.android.ui.styles.DefaultStyles
import org.android.ui.styles.Style
import org.android.ui.text.TextType
import org.android.ui.text.Typography

/**
 * Card Component Title
 */
@Composable
fun CardTitle(title: String, style: Style = DefaultStyles.Clickable.Cards.title, color: String = "text") {
    Typography(text = title, type = TextType.TITLE, style = style, color = color)
}

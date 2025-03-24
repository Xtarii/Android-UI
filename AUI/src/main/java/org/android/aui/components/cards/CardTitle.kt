package org.android.aui.components.cards

import androidx.compose.runtime.Composable
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.components.text.TextType
import org.android.aui.components.text.Typography

/**
 * Card Component Title
 */
@Composable
fun CardTitle(title: String, style: Style = DefaultStyles.Clickable.Cards.title, color: String = "text") {
    Typography(text = title, type = TextType.TITLE, style = style, color = color)
}

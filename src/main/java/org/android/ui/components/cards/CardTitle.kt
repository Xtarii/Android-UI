package org.android.ui.layouts.cards

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.android.ui.styles.DefaultStyles
import org.android.ui.styles.Style
import org.android.ui.text.TextType
import org.android.ui.text.Typography

/**
 * Card Component Title
 */
@Composable
fun CardTitle(title: String, style: Style = DefaultStyles.Clickable.Cards, color: String = "text") {
    Typography(text = title, type = TextType.TITLE, style = style, color = color)
}

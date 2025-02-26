package org.android.ui.layouts.cards

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.android.ui.styles.Style
import org.android.ui.text.TextType
import org.android.ui.text.Typography

/**
 * Default Card Title Style
 */
val DefaultCardTitleStyle: Style = Style(
    margin = PaddingValues(start = 12.dp, top = 4.dp),
    textSize = 0.65f
)



/**
 * Card Component Title
 */
@Composable
fun CardTitle(title: String, style: Style = DefaultCardTitleStyle, color: String = "text") {
    Typography(text = title, type = TextType.TITLE, style = style, color = color)
}

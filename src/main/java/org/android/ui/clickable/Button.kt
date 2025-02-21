package org.android.ui.clickable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Button as Bt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.android.ui.styles.Style

/**
 * Button Style Type
 */
enum class ButtonType {
    /**
     * Text Type, no border nor background only the content
     */
    TEXT,

    /**
     * Outlined Type, border and content but no background
     */
    OUTLINED,

    /**
     * Contained Type, Background and content
     */
    CONTAINED
}



/**
 * Button Component
 */
@Composable
fun Button(onClick: () -> Unit = {}, type: ButtonType = ButtonType.CONTAINED, style: Style = Style(), elevation: ButtonElevation = ButtonDefaults.buttonElevation(), disabled: Boolean = false, children: @Composable RowScope.() -> Unit = {}) {
    // Button style data
    val modifier: Modifier = if(type == ButtonType.CONTAINED) Modifier.shadow(style.shadow.elevation, shape = style.shadow.shape)
    else Modifier
    val border: BorderStroke? = if(type == ButtonType.OUTLINED) BorderStroke(1.dp, style.backgroundColor)
    else style.border
    val colors: ButtonColors = if(type == ButtonType.TEXT || type == ButtonType.OUTLINED) ButtonColors(
        Color.Transparent, style.color,
        Color.Transparent, style.color.copy(alpha = .3f)
    ) else ButtonColors(
        style.backgroundColor, style.color,
        style.backgroundColor.copy(alpha = .3f), style.color.copy(alpha = .3f)
    )



    // Button Element
    Box(modifier = Modifier.padding(style.margin)) {
        Bt(
            onClick = onClick,
            enabled = !disabled,
            shape = style.shape,
            elevation = elevation,
            colors = colors,
            modifier = modifier,
            contentPadding = style.padding,
            border = border,
        ) {
            children()
        }
    }
}

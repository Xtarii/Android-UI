package org.android.ui.clickable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
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
import org.android.ui.styles.theme.useTheme

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
fun Button(onClick: () -> Unit = {}, type: ButtonType = ButtonType.CONTAINED, color: String = "primary", style: Style = Style(padding = ButtonDefaults.ContentPadding), disabled: Boolean = false, children: @Composable () -> Unit = {}) {
    val theme = useTheme() // Gets Theme
    val mainColor = theme.getColor(color)
    val contentColor = theme.getColor("text")

    // Button style data
    val modifier: Modifier = if(type == ButtonType.CONTAINED) Modifier.shadow(style.shadow.elevation, shape = style.shadow.shape)
    else Modifier
    val border: BorderStroke? = if(type == ButtonType.OUTLINED) BorderStroke(style.borderSize.dp, mainColor)
    else style.border
    val colors: ButtonColors = if(type == ButtonType.TEXT || type == ButtonType.OUTLINED) ButtonColors(
        Color.Transparent, contentColor,
        Color.Transparent, contentColor.copy(alpha = .3f)
    ) else ButtonColors(
        mainColor, contentColor,
        mainColor.copy(alpha = .3f), contentColor.copy(alpha = .3f)
    )
    val elevation: ButtonElevation = if(type == ButtonType.CONTAINED || type == ButtonType.OUTLINED) ButtonDefaults.buttonElevation()
    else ButtonDefaults.buttonElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)



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

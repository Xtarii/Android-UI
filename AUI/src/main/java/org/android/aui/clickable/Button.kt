package org.android.aui.clickable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Button as Bt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.styles.theme.useTheme

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
fun Button(onClick: () -> Unit = {}, type: ButtonType = ButtonType.CONTAINED, color: String = "primary", style: Style = DefaultStyles.Clickable.button, disabled: Boolean = false, children: @Composable () -> Unit = {}) {
    val theme = useTheme() // Gets Theme
    val mainColor = style.backgroundColor ?: theme.getColor(color)
    val contentColor = style.color ?: theme.getColor("text")

    // Button style data
    val modifier: Modifier = if(type == ButtonType.CONTAINED) Modifier.shadow(style.shadow.elevation, shape = style.shadow.shape)
    else Modifier
    modifier
        .then(
            if(style.dimensions.fitSize) Modifier.wrapContentSize()
            else if(style.dimensions.maxSize) Modifier.fillMaxSize() else Modifier
        )
        .then(
            if(style.dimensions.fitWidth || style.dimensions.fitSize) Modifier.wrapContentWidth()
            else if(style.dimensions.maxWidth) Modifier.fillMaxWidth() else Modifier.width(style.dimensions.width)
        )
        .then(
            if(style.dimensions.fitHeight || style.dimensions.fitSize) Modifier.wrapContentHeight()
            else if(style.dimensions.maxHeight) Modifier.fillMaxHeight() else Modifier.height(style.dimensions.height)
        )

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

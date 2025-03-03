package org.android.ui.clickable.selection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.android.ui.styles.DefaultStyles
import org.android.ui.styles.Style
import org.android.ui.styles.theme.useTheme

/**
 * Selection Box Component
 */
@Preview
@Composable
fun SelectionBox(value: Boolean = false, onClick: () -> Unit = {}, style: Style = DefaultStyles.Clickable.selection, disabled: Boolean = false) {
    val theme = useTheme()
    val color = theme.getColor("outline")
    val contentColor = theme.getColor("text")



    // Content
    Box(modifier = Modifier.padding(style.margin)) {
        Button(onClick = onClick,
            enabled = !disabled,
            colors = ButtonColors(
                containerColor = Color.Transparent, contentColor = contentColor,
                disabledContainerColor = Color.Transparent, disabledContentColor = contentColor.copy(alpha = 0.3f)
            ),
            border = BorderStroke(style.borderSize.dp, color),
            shape = RoundedCornerShape(2.dp),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.size(style.size),
        ) {
            if(value) Icon(Icons.Filled.Check, "boolean", modifier = Modifier.fillMaxSize())
        }
    }
}



/**
 * Boolean Component
 *
 * Similar to the ```SelectionBox```,
 * however the ```Boolean``` takes the
 * form of a slider rather than a small box.
 */
@Preview
@Composable
fun Boolean(value: Boolean = false, onClick: () -> Unit = {}, color: String = "primary", style: Style = DefaultStyles.Clickable.boolean, disabled: Boolean = false) {
    val theme = useTheme()
    val main: Color = if(!value) theme.getColor("background") else theme.getColor(color)
    val text = theme.getColor("text")

    val colors = ButtonColors(
        containerColor = main, contentColor = text,
        disabledContainerColor = main.copy(alpha = 0.3f), disabledContentColor = text.copy(alpha = 0.3f)
    )



    // Boolean Content
    Box(modifier = Modifier.padding(style.margin)) {
        Button(onClick = onClick,
            enabled = !disabled,
            colors = colors,
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.width(style.width).height(style.height)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.size((style.height))
                    .background(color = text, shape = CircleShape)
                    .align(if(value) Alignment.CenterEnd else Alignment.CenterStart)
                )
            }
        }
    }
}

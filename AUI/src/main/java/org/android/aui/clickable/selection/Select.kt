package org.android.aui.clickable.selection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.styles.theme.useTheme

/**
 * Selection Box Component
 */
@Preview
@Composable
fun SelectionBox(value: Boolean = false, onClick: () -> Unit = {}, style: Style = DefaultStyles.Clickable.selection, disabled: Boolean = false) {
    val theme = useTheme()
    var color = style.backgroundColor ?: theme.getColor("outline")
    if(disabled) color = color.copy(alpha = 0.4f)
    val contentColor = style.color ?: theme.getColor("text")

    // Modifier
    val modifier = Modifier.then(if (style.dimensions.maxSize) Modifier.fillMaxSize() else Modifier.size(style.dimensions.size))



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
            modifier = modifier,
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
fun Switch(value: Boolean = false, onClick: () -> Unit = {}, color: String = "primary", style: Style = DefaultStyles.Clickable.switch, disabled: Boolean = false) {
    val theme = useTheme()
    val main = if(!value) theme.getColor("background") else theme.getColor(color)
    val text = style.color ?: theme.getColor("text")

    val colors = ButtonColors(
        containerColor = main, contentColor = text,
        disabledContainerColor = main.copy(alpha = 0.3f), disabledContentColor = text.copy(alpha = 0.3f)
    )

    // Modifier
    val modifier = Modifier
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



    // Boolean Content
    Box(modifier = Modifier.padding(style.margin)) {
        Box(modifier = Modifier, contentAlignment = Alignment.Center) {
            Button(
                onClick = onClick,
                enabled = !disabled,
                colors = colors,
                contentPadding = PaddingValues(0.dp),
                modifier = modifier.then(Modifier.align(Alignment.Center))
            ) {}
            Box(modifier = Modifier.width(style.dimensions.width)) {
                Box(modifier = Modifier.requiredSize((style.dimensions.height + 4.dp))
                    .background(color = text, shape = CircleShape)
                    .align(if (value) Alignment.CenterEnd else Alignment.CenterStart)
                )
            }
        }
    }
}

package org.android.ui.clickable.selection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
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

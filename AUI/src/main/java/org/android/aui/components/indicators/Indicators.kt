package org.android.aui.components.indicators

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.styles.theme.useTheme

@Preview
@Composable
fun LinearProgress(color: String = "primary", background: String = "background", style: Style = DefaultStyles.Indicator.linear) {
    val theme = useTheme()
    val mainColor = style.color ?: theme.getColor(color)
    val backgroundColor = style.backgroundColor ?: theme.getColor(background)

    // Modifier
    val modifier = Modifier
        .then(if(style.dimensions.maxSize) Modifier.fillMaxSize() else Modifier)
        .then(if(style.dimensions.maxWidth) Modifier.fillMaxWidth() else Modifier.width(style.dimensions.width))
        .then(if(style.dimensions.maxHeight) Modifier.fillMaxHeight() else Modifier.height(style.dimensions.height))

    // Progress Bar
    Box(modifier = Modifier.padding(style.margin)) {
        LinearProgressIndicator(
            modifier = modifier,
            color = mainColor,
            trackColor = backgroundColor
        )
    }
}

package org.android.ui.clickable.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.android.ui.styles.Style
import org.android.ui.styles.shadows.Shadows
import org.android.ui.styles.theme.useTheme

/**
 * Default Card Style
 */
val DefaultCardStyle: Style = Style(
    width = 150.dp,
    height = 200.dp,
    shadow = Shadows().copy(
        elevation = 15.dp,
        ambient = DefaultShadowColor,
        spot = DefaultShadowColor,
    )
)



/**
 * Card Component
 */
@Preview
@Composable
fun Card(onClick: () -> Unit = {}, style: Style = DefaultCardStyle, color: String = "background", children: @Composable () -> Unit = {}) {
    val theme = useTheme()


    // Content
    Box(modifier = Modifier.padding(style.margin), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier.width(style.width).height(style.height)) {
            Button(
                onClick = onClick,
                shape = style.shape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.fillMaxSize()
                    .shadow(
                        style.shadow.elevation,
                        style.shadow.shape,
                        style.shadow.clip,
                        style.shadow.ambient,
                        style.shadow.spot
                    )
            ) {
                Column(modifier = Modifier.fillMaxSize().background(theme.getColor(color))) {
                    children()
                }
            }
        }
    }
}

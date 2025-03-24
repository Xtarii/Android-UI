package org.android.aui.clickable.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.styles.theme.useTheme

/**
 * Card Component
 */
@Preview
@Composable
fun Card(onClick: () -> Unit = {}, style: Style = DefaultStyles.Clickable.Cards.main, color: String = "background", children: @Composable () -> Unit = {}) {
    val theme = useTheme()
    val mainColor = style.backgroundColor ?: theme.getColor(color)

    // Card Modifier
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


    // Content
    Box(modifier = Modifier.padding(style.margin), contentAlignment = Alignment.Center) {
        Box(modifier = modifier) {
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
                Column(modifier = Modifier.fillMaxSize().background(mainColor)) {
                    children()
                }
            }
        }
    }
}

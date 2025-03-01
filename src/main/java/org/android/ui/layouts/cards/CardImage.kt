package org.android.ui.layouts.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.android.ui.styles.Style

/**
 * Default Card Image Style
 */
val DefaultCardImageStyle: Style = Style(
    height = 100.dp
)



/**
 * Card Component Image
 */
@Composable
fun CardImage(image: String, alt: String, style: Style = DefaultCardImageStyle) {
    AsyncImage(
        model = image,
        contentDescription = alt,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().height(style.height)
    )
}



/**
 * Card Component Image
 */
@Composable
fun CardImage(image: Int, alt: String, style: Style = DefaultCardImageStyle) {
    Image(
        painter = painterResource(image),
        contentDescription = alt,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().height(style.height)
    )
}

package org.android.ui.layouts.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import org.android.ui.styles.DefaultStyles
import org.android.ui.styles.Style

/**
 * Card Component Image
 */
@Composable
fun CardImage(image: String, alt: String, style: Style = DefaultStyles.Clickable.Cards.image) {
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
fun CardImage(image: Int, alt: String, style: Style = DefaultStyles.Clickable.Cards.image) {
    Image(
        painter = painterResource(image),
        contentDescription = alt,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth().height(style.height)
    )
}

package org.android.aui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style

/**
 * Card Component Image
 */
@Composable
fun CardImage(image: String, alt: String, style: Style = DefaultStyles.Clickable.Cards.image) {
    val modifier = Modifier
        .then(if (style.dimensions.maxSize) Modifier.fillMaxSize() else Modifier)
        .then(if (style.dimensions.maxWidth) Modifier.fillMaxWidth() else Modifier.width(style.dimensions.width))
        .then(if (style.dimensions.maxHeight) Modifier.fillMaxHeight() else Modifier.height(style.dimensions.height))

    // Image
    AsyncImage(
        model = image,
        contentDescription = alt,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}



/**
 * Card Component Image
 */
@Composable
fun CardImage(image: Int, alt: String, style: Style = DefaultStyles.Clickable.Cards.image) {
    val modifier = Modifier
        .then(if (style.dimensions.maxSize) Modifier.fillMaxSize() else Modifier)
        .then(if (style.dimensions.maxWidth) Modifier.fillMaxWidth() else Modifier.width(style.dimensions.width))
        .then(if (style.dimensions.maxHeight) Modifier.fillMaxHeight() else Modifier.height(style.dimensions.height))

    // Image
    Image(
        painter = painterResource(image),
        contentDescription = alt,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

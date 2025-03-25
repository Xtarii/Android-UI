package org.android.aui.styles.objects

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Component Dimensions Style
 */
data class Dimensions (
    /**
     * Width
     */
    val width: Dp = 0.dp,
    /**
     * Use Max Width on Component
     */
    val maxWidth: Boolean = false,
    /**
     * Component Fit Content Width
     */
    val fitWidth: Boolean = false,

    /**
     * Height
     */
    val height: Dp = 0.dp,
    /**
     * Use Max Height on Component
     */
    val maxHeight: Boolean = false,
    /**
     * Component Fit Content Height
     */
    val fitHeight: Boolean = false,

    /**
     * Size
     *
     * Components that use
     * size excludes ```width```
     * and ```height``` as both
     * those values will
     * be set by the ```size```.
     */
    val size: Dp = 0.dp,
    /**
     * Use Max Size on Component
     */
    val maxSize: Boolean = false,
    /**
     * Component Fit Content Size
     */
    val fitSize: Boolean = false,

    /**
     * Z Index
     *
     * This will determine if the
     * component will render behind
     * or in-front of other components.
     */
    val z: Int = 0,
) {
    /**
     * Gets the preferred style size
     * on a component
     */
    fun getSize() : Modifier {
        return Modifier
            .then(
                if(fitSize) Modifier.wrapContentSize()
                else if(maxSize) Modifier.fillMaxSize() else Modifier
            )
            .then(
                if(fitWidth || fitSize) Modifier.wrapContentWidth()
                else if(maxWidth) Modifier.fillMaxWidth() else Modifier.width(width)
            )
            .then(
                if(fitHeight || fitSize) Modifier.wrapContentHeight()
                else if(maxHeight) Modifier.fillMaxHeight() else Modifier.height(height)
            )
    }
}

package org.android.aui.styles.objects

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Component Dimensions Style
 */
data class Dimensions(
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
)

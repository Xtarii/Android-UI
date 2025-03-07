package org.android.ui.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.android.ui.styles.shadows.Shadows
import org.android.ui.styles.text.TextStyle

/**
 * Component Style Data
 */
data class Style (
    /**
     * Component Background Color
     *
     * By default this is set
     * and controlled by the
     * current theme.
     */
    val backgroundColor: Color? = null,
    /**
     * Component Content Color
     *
     * By default this is set
     * and controlled by the
     * current theme.
     */
    val color: Color? = null,

    /**
     * Component Margin Values
     */
    val margin: PaddingValues = PaddingValues(0.dp),
    /**
     * Component Padding Values
     */
    val padding: PaddingValues = PaddingValues(5.dp),

    /**
     * Component Shape
     */
    val shape: Shape = RoundedCornerShape(15.dp),
    /**
     * Component Width
     */
    val width: Dp = 0.dp,
    /**
     * Component Height
     */
    val height: Dp = 0.dp,
    /**
     * Component Size
     *
     * Components that use
     * size excludes ```width```
     * and ```height``` as both
     * those values will
     * be set by the ```size```.
     */
    val size: Dp = 0.dp,

    /**
     * Component Z Index
     *
     * This will determine if the
     * component will render behind
     * or in-front of other components.
     */
    val z: Int = 0,

    /**
     * Component Alignment
     */
    val alignment: Alignment = Alignment.Center,
    /**
     * Component Inner Alignment
     */
    val innerAlignment: Alignment = Alignment.Center,

    /**
     * Component Border
     */
    val border: BorderStroke? = null,
    /**
     * Component Border Size
     */
    val borderSize: Float = 2f,
    /**
     * Component Underline
     */
    val underline: Boolean = false,

    /**
     * Component Shadow
     */
    val shadow: Shadows = Shadows(),



    /**
     * Component Text Related Style Config
     */
    val text: TextStyle = TextStyle()
)

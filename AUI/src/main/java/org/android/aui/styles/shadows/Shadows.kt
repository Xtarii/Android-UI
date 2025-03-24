package org.android.aui.styles.shadows

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Shadows Style Class
 */
data class Shadows (
    /**
     * Shadow Evaluation
     */
    val elevation: Dp = 5.dp,

    /**
     * Shadow Shape
     */
    val shape: Shape = RoundedCornerShape(5.dp),

    /**
     * Shadow Clipping
     */
    val clip: Boolean = elevation > 0.dp,

    /**
     * Shadow Ambient Color
     */
    val ambient: Color = Color.Transparent,
    /**
     * Shadow Spot Color
     */
    val spot: Color = Color.Transparent,
)

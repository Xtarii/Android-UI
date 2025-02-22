package org.android.ui.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import org.android.ui.styles.shadows.Shadows

/**
 * Component Style Data
 */
data class Style (
    /**
     * Component Background Color
     */
    val backgroundColor: Color = Color.Transparent,
    /**
     * Component Content Color
     */
    val color: Color = Color.Black,

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
    val shape: Shape = RoundedCornerShape(5.dp),

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
    val shadow: Shadows = Shadows()
)

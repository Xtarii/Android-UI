package org.android.aui.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import org.android.aui.styles.objects.Dimensions
import org.android.aui.styles.shadows.Shadows
import org.android.aui.styles.text.TextStyle

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
     * Component Dimensions Style
     *
     * A components dimensions is
     * its height, width and
     * other size related styling
     */
    val dimensions: Dimensions = Dimensions(),



    /**
     * Component Alignment
     */
    val alignment: Alignment = Alignment.Center,
    /**
     * Component Inner Alignment
     */
    val innerAlignment: Alignment = Alignment.Center,
    /**
     * Component Display Inner Components in a vertical alignment
     */
    val vertical: Boolean = true,
    /**
     * Component Scroll
     */
    val scroll: Boolean = false,

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

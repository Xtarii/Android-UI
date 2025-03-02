package org.android.ui.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.unit.dp
import org.android.ui.styles.shadows.Shadows

/**
 * Default Android UI Styles
 */
object DefaultStyles {
    /**
     * Default Clickable Styles
     */
    object Clickable {
        /**
         * Default Selection Box Style
         */
        val selection: Style = Style(
            borderSize = 2f,
            size = 25.dp
        )

        /**
         * Default Button Style
         */
        val button: Style = Style(padding = ButtonDefaults.ContentPadding)



        /**
         * Default Card Styles
         */
        object Cards {
            /**
             * Main Style
             */
            val main: Style = Style(
                width = 150.dp,
                height = 200.dp,
                shadow = Shadows().copy(
                    elevation = 15.dp,
                    ambient = DefaultShadowColor,
                    spot = DefaultShadowColor,
                )
            )

            /**
             * Image Style
             */
            val image: Style = Style(height = 100.dp)
            /**
             * Text Style
             */
            val text: Style = Style(margin = PaddingValues(start = 12.dp, top = 4.dp))
            /**
             * Title Style
             */
            val title: Style = Style(margin = PaddingValues(start = 12.dp, top = 4.dp), textSize = 0.65f)
        }
    }
}

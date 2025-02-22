package org.android.ui.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.android.ui.styles.Style
import org.android.ui.styles.theme.useTheme

/**
 * Text Types
 */
enum class TextType(val value: TextUnit) {
    /**
     * Title Text
     */
    TITLE(28.sp),
    /**
     * Medium Title Text
     */
    MEDIUM_TITLE(24.sp),

    /**
     * Paragraph Text
     */
    PARAGRAPH(14.sp),
}



/**
 * Typography Text Component
 */
@Preview
@Composable
fun Typography(text: String = "", type: TextType = TextType.PARAGRAPH, color: String = "text", style: Style = Style()) {
    val theme = useTheme()
    val textColor = theme.getColor(color)


    Box(modifier = Modifier.padding(style.margin)) {
        Text(text, fontSize = type.value, color = textColor,
            modifier = Modifier.drawBehind {
                if(style.underline) drawLine(
                    color = textColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = style.borderSize
                )
            }
        )
    }
}

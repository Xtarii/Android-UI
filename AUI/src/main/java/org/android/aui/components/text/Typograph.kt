package org.android.aui.components.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.styles.theme.useTheme

/**
 * Text Types
 */
enum class TextType(val value: Float) {
    /**
     * Title Text
     */
    TITLE(28f),
    /**
     * Medium Title Text
     */
    MEDIUM_TITLE(24f),

    /**
     * Paragraph Text
     */
    PARAGRAPH(14f),
}



/**
 * Typography Text Component
 */
@Preview
@Composable
fun Typography(text: String = "", type: TextType = TextType.PARAGRAPH, color: String = "text", style: Style = DefaultStyles.typography) {
    val theme = useTheme()
    val textColor = style.color ?: theme.getColor(color)


    Box(modifier = Modifier.padding(style.margin)) {
        Text(text, fontSize = (type.value * style.text.textSize).sp, fontFamily = style.text.fontFamily, fontWeight = style.text.fontWeight, color = textColor,
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

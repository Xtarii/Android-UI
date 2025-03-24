package org.android.aui.clickable.radio

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.android.aui.components.text.Typography
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style

/**
 * Radio Button Object
 */
class Radio<T>(
    /**
     * Radio Value
     */
    val value: T,
    /**
     * Radio Label
     */
    val label: String,

    /**
     * Radio Style
     */
    val style: Style = DefaultStyles.Radio.button,

    /**
     * Weather or not this Radio Button should be disabled
     */
    val disabled: Boolean = false,



    /**
     * Radio Slot
     *
     * The visual representation of
     * this radio object.
     */
    val slot: @Composable (active: Boolean) -> Unit = { active ->
        val icon = if(active) Icons.Filled.CheckCircle else Icons.Outlined.Circle
        Row(modifier = Modifier.fillMaxSize().padding(0.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, "Box")
            Typography(label, style = DefaultStyles.typography.copy(
                margin = PaddingValues(start = 7.dp)
            ))
        }
    },
)

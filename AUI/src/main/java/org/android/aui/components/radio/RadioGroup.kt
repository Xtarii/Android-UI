package org.android.aui.components.radio

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.android.aui.clickable.Button
import org.android.aui.clickable.ButtonType
import org.android.aui.clickable.radio.Radio
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style

/**
 * Radio Group Component
 */
@Preview
@Composable
fun <T> RadioGroup(
    value: T? = null,
    onChange: (value: T) -> Unit = {},
    options: MutableList<Radio<T>> = ArrayList(),
    style: Style = DefaultStyles.Radio.group
) {
    val modifier = Modifier.background(style.color ?: Color.Transparent, shape = style.shape)
        .then(
            if(style.dimensions.fitSize) Modifier.wrapContentSize()
            else if(style.dimensions.maxSize) Modifier.fillMaxSize() else Modifier
        )
        .then(
            if(style.dimensions.fitWidth || style.dimensions.fitSize) Modifier.wrapContentWidth()
            else if(style.dimensions.maxWidth) Modifier.fillMaxWidth() else Modifier.width(style.dimensions.width)
        )
        .then(
            if(style.dimensions.fitHeight || style.dimensions.fitSize) Modifier.wrapContentHeight()
            else if(style.dimensions.maxHeight) Modifier.fillMaxHeight() else Modifier.height(style.dimensions.height)
        )

    // Content
    Box(modifier = Modifier.padding(style.margin)) {
        if(style.vertical) LazyColumn(modifier, userScrollEnabled = style.scroll) { items(options) { Inner(value, onChange, it) } }
        else LazyRow(modifier, userScrollEnabled = style.scroll) { items(options) { Inner(value, onChange, it) } }
    }
}





@Composable
private fun <T> Inner(value: T?, onChange: (value: T) -> Unit, item: Radio<T>) {
    Button(onClick = { onChange(item.value) }, type = ButtonType.TEXT, style = item.style, disabled = item.disabled) {
        item.slot(value == item.value)
    }
}

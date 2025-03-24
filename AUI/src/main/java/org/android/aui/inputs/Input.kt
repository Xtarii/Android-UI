package org.android.aui.inputs

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.Style
import org.android.aui.styles.theme.useTheme

/**
 * Text Input Field Slots
 */
data class Slots (
    /**
     * Text Field Icon Slot
     */
    val icon: (@Composable () -> Unit)? = null,
    /**
     * Text Field End Slot
     */
    val end: (@Composable () -> Unit)? = null,
)

/**
 * Text Input Field Type
 */
enum class InputFieldType {
    /**
     * Outline Text Input Field
     */
    OUTLINE,
    /**
     * Underline Text Input Field
     */
    UNDERLINE,
}





/**
 * Input Text Field Component
 */
@Preview
@Composable
fun Input(
    value: String = "", onChange: (String) -> Unit = {},
    placeholder: String = "Enter text...",

    type: InputFieldType = InputFieldType.OUTLINE,
    style: Style = DefaultStyles.Input.input,
    color: String = "background",
    text: String = "text",

    hiddenInput: MutableState<Boolean> = rememberSaveable{ mutableStateOf(style.text.keyboardType == KeyboardType.Password) },
    disabled: Boolean = false,
    error: Boolean = false,

    slots: Slots = Slots(
        end = if(style.text.keyboardType == KeyboardType.Password) ({
            val image = if(hiddenInput.value) Icons.Filled.Lock
            else Icons.Outlined.Lock
            val description = if(hiddenInput.value) "Hide" else "Show"
            IconButton(onClick = { hiddenInput.value = !hiddenInput.value }) {
                Icon(imageVector = image, description)
            }
        }) else null
    )
) {
    // Text Input Field Style and Config
    val theme = useTheme()
    val mainColor = style.backgroundColor ?: theme.getColor(color)
    val textColor = style.color ?: theme.getColor(text)



    // Text Input Field
    Box(modifier = Modifier.padding(style.margin)) {
        if(type == InputFieldType.OUTLINE) // Outline Input Field
            Outline(value, onChange, placeholder, slots, mainColor, textColor, error, hiddenInput.value, disabled, style)
        else if(type == InputFieldType.UNDERLINE)
            Underline(value, onChange, placeholder, slots, mainColor, textColor, error, hiddenInput.value, disabled, style)
    }
}





@Composable
private fun Outline(
    value: String, onChange: (String) -> Unit,
    placeholder: String,

    slots: Slots,

    mainColor: Color, textColor: Color,
    error: Boolean, hiddenInput: Boolean, disabled: Boolean,
    style: Style
) {
    // Modifier
    val modifier = Modifier
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

    // Input
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = { Text(placeholder, color = textColor.copy(alpha = 0.4f)) },
        shape = style.shape,
        singleLine = !style.text.multiline,
        textStyle = TextStyle(color = textColor),
        colors = OutlinedTextFieldDefaults.colors().copy(
            unfocusedIndicatorColor = mainColor,
            focusedIndicatorColor = mainColor,
        ),
        modifier = modifier,

        visualTransformation = if(!hiddenInput) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = style.text.keyboardType),
        leadingIcon = slots.icon,
        trailingIcon = slots.end,
        isError = error,
        enabled = !disabled,
        readOnly = style.text.readonly
    )
}

@Composable
private fun Underline(
    value: String, onChange: (String) -> Unit,
    placeholder: String,

    slots: Slots,

    mainColor: Color, textColor: Color,
    error: Boolean, hiddenInput: Boolean, disabled: Boolean,
    style: Style
) {
    // Modifier
    val modifier = Modifier
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

    // Input
    TextField(
        value = value,
        onValueChange = onChange,
        label = { Text(placeholder, color = textColor.copy(alpha = 0.4f)) },
        shape = style.shape,
        singleLine = !style.text.multiline,
        textStyle = TextStyle(color = textColor),
        colors = OutlinedTextFieldDefaults.colors().copy(
            unfocusedIndicatorColor = mainColor,
            focusedIndicatorColor = mainColor,
        ),
        modifier = modifier,

        visualTransformation = if(!hiddenInput) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = style.text.keyboardType),
        leadingIcon = slots.icon,
        trailingIcon = slots.end,
        isError = error,
        enabled = !disabled,
        readOnly = style.text.readonly
    )
}

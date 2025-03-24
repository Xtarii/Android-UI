package org.android.aui.components.async

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Suspended(fallback: @Composable () -> Unit = {}, children: suspend () -> @Composable () -> Unit = {{}}) {
    var load by remember { mutableStateOf(true) }
    var content by remember { mutableStateOf<@Composable () -> Unit>({}) }

    // Loads Content
    LaunchedEffect(Unit) {
        content = children()
        load = false
    }

    // Content
    if(load) fallback()
    else content()
}

package org.android.ui.backend.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.android.ui.clickable.Button
import org.android.ui.styles.Style
import org.android.ui.styles.theme.useTheme
import org.android.ui.text.TextType
import org.android.ui.text.Typography

/**
 * Default Home Page for Android UI Package
 */
@Preview
@Composable
fun StarterPage() {
    val theme = useTheme()


    // Content
    Column(modifier = Modifier.fillMaxSize().fillMaxSize().background(theme.getBackground())) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Typography("Welcome to Android UI", type = TextType.TITLE,
                style = Style(margin = PaddingValues(bottom = 50.dp, top = 250.dp)
                )
            )
        }
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(style = Style(padding = PaddingValues(15.dp)), onClick = {
                    theme.dark = !theme.dark
            }) {
                Typography("Theme Switch", color = "dark text")
            }
        }
    }
}

package org.android.aui.backend.pages

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
import org.android.aui.backend.router.useRouter
import org.android.aui.clickable.Button
import org.android.aui.components.text.TextType
import org.android.aui.components.text.Typography
import org.android.aui.styles.DefaultStyles
import org.android.aui.styles.theme.useTheme

@Preview
@Composable
fun Error() {
    val theme = useTheme()
    val router = useRouter()


    // Content
    Column(modifier = Modifier.fillMaxSize().fillMaxSize().background(theme.background)) {
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Typography("Could not load the page", type = TextType.TITLE,
                style = DefaultStyles.typography.copy(margin = PaddingValues(bottom = 50.dp, top = 250.dp)),
                color = "error"
            )
        }
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Button(style = DefaultStyles.Clickable.button.copy(padding = PaddingValues(15.dp)), onClick = {
                router.setLocation()
            }) {
                Typography("Back to home", color = "dark text")
            }
        }
    }
}

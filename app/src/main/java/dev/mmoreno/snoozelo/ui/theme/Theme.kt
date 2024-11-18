package dev.mmoreno.snoozelo.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    surface = WhiteColor,
    background = BackgroundColor
)

@OptIn(ExperimentalMaterial3Api::class)
val LocalAppBarColors = staticCompositionLocalOf<TopAppBarColors> {
    error("No AppBarColors provided")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnoozeloTheme(
    content: @Composable () -> Unit
) {
    val appBarColors = TopAppBarDefaults.topAppBarColors(containerColor = BackgroundColor)

    CompositionLocalProvider(LocalAppBarColors provides appBarColors) {
        MaterialTheme(
            colorScheme = LightColorScheme,
            typography = Typography,
            content = content
        )
    }
}

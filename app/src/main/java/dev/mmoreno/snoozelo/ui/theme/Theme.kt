package dev.mmoreno.snoozelo.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.mmoreno.snoozelo.R

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

val MontserratFontFamily = FontFamily(
    Font(R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold),
    Font(R.font.montserrat_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.montserrat_thin, weight = FontWeight.Thin),
    Font(R.font.montserrat_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.montserrat_medium, weight = FontWeight.Medium),
    Font(R.font.montserrat_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.montserrat_light, weight = FontWeight.Light),
    Font(R.font.montserrat_black, weight = FontWeight.Black),
)

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

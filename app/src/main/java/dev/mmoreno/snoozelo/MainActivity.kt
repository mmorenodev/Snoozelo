package dev.mmoreno.snoozelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dev.mmoreno.snoozelo.ui.extensions.loadAndStartObjectAnimator
import dev.mmoreno.snoozelo.ui.navigation.SnoozeloNavHost
import dev.mmoreno.snoozelo.ui.theme.SnoozeloTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setOnExitAnimationListener { screenProvider ->
                loadAndStartObjectAnimator(R.animator.exit_logo_animator, screenProvider.iconView) {
                    screenProvider.remove()
                }
            }
        }
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            SnoozeloTheme {
                SnoozeloNavHost(navController)
            }
        }
    }
}
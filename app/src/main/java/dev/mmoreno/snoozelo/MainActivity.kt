package dev.mmoreno.snoozelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.compose.rememberNavController
import dev.mmoreno.snoozelo.ui.extensions.loadAndStartObjectAnimator
import dev.mmoreno.snoozelo.navigation.SnoozeloNavHost
import dev.mmoreno.snoozelo.ui.theme.SnoozeloTheme
import dev.mmoreno.snoozelo.ui.your_alarms.YourAlarmsViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: YourAlarmsViewModel by viewModel()

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

    override fun onResume() {
        super.onResume()
        /*lifecycleScope.launch {
            delay(4000)
            viewModel.saveAlarm("It's the dunno time", System.currentTimeMillis().toString())
        }*/
    }
}
package dev.mmoreno.snoozelo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mmoreno.snoozelo.ui.YourAlarmsScreen
import dev.mmoreno.snoozelo.ui.navigation.Route.YourAlarms

@Composable
fun SnoozeloNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = YourAlarms.route
    ) {
        composable(YourAlarms.route) {
            YourAlarmsScreen()
        }
    }
}
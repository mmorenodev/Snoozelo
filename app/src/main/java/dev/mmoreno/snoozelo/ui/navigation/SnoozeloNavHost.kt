package dev.mmoreno.snoozelo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.mmoreno.snoozelo.R
import dev.mmoreno.snoozelo.ui.AlarmSettingsScreen
import dev.mmoreno.snoozelo.ui.YourAlarmsScreen
import dev.mmoreno.snoozelo.ui.navigation.SnoozeloScreen.YourAlarms
import dev.mmoreno.snoozelo.ui.navigation.SnoozeloScreen.AlarmSettings

@Composable
fun SnoozeloNavHost(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = YourAlarms.route
    ) {
        composePrimaryDestination(YourAlarms.route) {
            YourAlarmsScreen(
                DestinationType.PrimaryDestination(
                    R.string.your_alarms_screen_title
                )
            ) {
                navHostController.navigate(AlarmSettings.route)
            }
        }
        composeSecondaryDestination(AlarmSettings.route) {
            AlarmSettingsScreen(
                DestinationType.SecondaryDestination {
                    navHostController.popBackStack()
                }
            )
        }
    }
}

fun NavGraphBuilder.composePrimaryDestination(
    route: String,
    content: @Composable () -> Unit
) {
    composable(route) {
        content()
    }
}

fun NavGraphBuilder.composeSecondaryDestination(
    route: String,
    content: @Composable () -> Unit
) {
    composable(route) {
        content()
    }
}
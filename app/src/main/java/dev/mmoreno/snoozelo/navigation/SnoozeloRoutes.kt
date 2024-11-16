package dev.mmoreno.snoozelo.navigation

import androidx.annotation.StringRes

sealed class SnoozeloScreen(
    val route: String,
) {
    data object YourAlarms : SnoozeloScreen(
        route = "your_alarms"
    )

    data object AlarmSettings : SnoozeloScreen(
        route = "alarm_settings",
    )
}

sealed interface DestinationType {
    data class PrimaryDestination(@StringRes val title: Int) : DestinationType
    data class SecondaryDestination(
        val onNavigationIconClick: () -> Unit
    ) : DestinationType
}

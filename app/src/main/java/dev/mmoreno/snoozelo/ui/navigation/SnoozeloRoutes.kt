package dev.mmoreno.snoozelo.ui.navigation

sealed class Route(val route: String) {
    data object YourAlarms : Route("your_alarms")
}
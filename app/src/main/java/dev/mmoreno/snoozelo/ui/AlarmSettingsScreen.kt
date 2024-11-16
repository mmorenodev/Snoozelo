package dev.mmoreno.snoozelo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.mmoreno.snoozelo.ui.common.SnoozeloTopAppBar
import dev.mmoreno.snoozelo.navigation.DestinationType

@Composable
fun AlarmSettingsScreen(
    destinationType: DestinationType,
) {
    Scaffold(topBar = {
        SnoozeloTopAppBar(destinationType)
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text("Alarm settings")
        }
    }
}
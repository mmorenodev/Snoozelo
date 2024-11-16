package dev.mmoreno.snoozelo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mmoreno.snoozelo.R
import dev.mmoreno.snoozelo.ui.common.SnoozeloTopAppBar
import dev.mmoreno.snoozelo.ui.navigation.DestinationType
import dev.mmoreno.snoozelo.ui.theme.PrimaryColor
import dev.mmoreno.snoozelo.ui.theme.SnoozeloTheme
import dev.mmoreno.snoozelo.ui.theme.WhiteColor

@Composable
fun YourAlarmsScreen(
    destinationType: DestinationType,
    onAddAlarmClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            SnoozeloTopAppBar(destinationType)
        },
        floatingActionButton = {
            IconButton(
                onClick = onAddAlarmClick,
                colors = IconButtonDefaults.iconButtonColors().copy(
                    containerColor = PrimaryColor,
                    contentColor = WhiteColor,
                ),
                modifier = Modifier.size(60.dp)
            ) {
                Icon(painter = painterResource(R.drawable.ic_add), contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Text("Your alarms")
        }
    }
}

@Composable
fun AlarmItem(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row {
            Text("Wake up")
            Switch(checked = true, onCheckedChange = { })
        }
        Row {
            Text("7:00")
            Text("AM")
        }
        Text("Alarm in 10 hours")
    }
}

@Preview
@Composable
private fun AlarmItemPreview() {
    SnoozeloTheme { AlarmItem() }
}
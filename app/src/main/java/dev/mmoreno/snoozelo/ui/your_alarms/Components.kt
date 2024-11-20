package dev.mmoreno.snoozelo.ui.your_alarms

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mmoreno.snoozelo.R
import dev.mmoreno.snoozelo.domain.AlarmDomain
import dev.mmoreno.snoozelo.ui.theme.PrimaryColor
import dev.mmoreno.snoozelo.ui.theme.SnoozeloTheme
import dev.mmoreno.snoozelo.ui.theme.WhiteColor

@Composable
fun AddAlarmButton(onAddAlarmClick: () -> Unit) {
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
}

@Composable
fun AlarmItem(
    alarm: AlarmDomain,
    onCheckedChange: (Boolean) -> Unit = {},
    onDeleteAlarm: (AlarmDomain) -> Unit = {}
) {
    val swipeToDismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            if (it == SwipeToDismissBoxValue.StartToEnd) {
                onDeleteAlarm(alarm)
            }
            false
        })

    val iconColor by animateColorAsState(
        targetValue = when (swipeToDismissState.targetValue) {
            SwipeToDismissBoxValue.StartToEnd ->
                MaterialTheme.colorScheme.onError

            else -> MaterialTheme.colorScheme.onSurface
        },
        animationSpec = tween(),
    )

    SwipeToDismissBox(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(Color.Red),
        state = swipeToDismissState,
        backgroundContent = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
                    .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = iconColor
                )
            }
        },
        enableDismissFromStartToEnd = true,
        enableDismissFromEndToStart = false
    ) {
        Surface(modifier = Modifier) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row {
                    Text(alarm.title, modifier = Modifier.weight(1f))
                    Switch(
                        checked = alarm.isEnabled,
                        onCheckedChange = { onCheckedChange(it) },
                    )
                }
                Row {
                    Text(alarm.time)
                    Text("AM")
                }
                Text("Alarm in 10 hours")
            }
        }
    }
}

@Preview
@Composable
private fun AlarmItemPreview() {
    SnoozeloTheme { AlarmItem(AlarmDomain(title = "Wake Up", time = "10:00 AM")) }
}

@Composable
fun YourAlarmsEmptyMessage() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_alarm_clock),
            contentDescription = null
        )
        Text(
            stringResource(R.string.your_alarms_empty_message),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun YourAlarmsEmptyMessagePreview() {
    YourAlarmsEmptyMessage()
}

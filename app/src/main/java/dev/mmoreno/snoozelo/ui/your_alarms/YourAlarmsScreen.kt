package dev.mmoreno.snoozelo.ui.your_alarms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.mmoreno.snoozelo.domain.AlarmDomain
import dev.mmoreno.snoozelo.ui.common.SnoozeloTopAppBar
import dev.mmoreno.snoozelo.navigation.DestinationType
import org.koin.androidx.compose.koinViewModel

@Composable
fun YourAlarmsScreen(
    destinationType: DestinationType,
    viewModel: YourAlarmsViewModel = koinViewModel(),
    onAddAlarmClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            SnoozeloTopAppBar(destinationType)
        },
        floatingActionButton = {
            AddAlarmButton(onAddAlarmClick)
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        YourAlarmsScreenContent(uiState, paddingValues) {
            viewModel.onEvent(it)
        }
    }
}

@Composable
private fun YourAlarmsScreenContent(
    uiState: YourAlarmsUiState,
    paddingValues: PaddingValues,
    onViewEvent: (YourAlarmsEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(horizontal = 16.dp),
        verticalArrangement = if (uiState.shouldShowEmptyState) Arrangement.Center else Arrangement.Top
    ) {
        if (uiState.shouldShowEmptyState) {
            YourAlarmsEmptyMessage()
        } else {
            AlarmsList(alarms = uiState.alarms,
                onAlarmCheckChange = { alarm, isEnabled ->
                    onViewEvent(
                        YourAlarmsEvent.EnableDisableAlarm(
                            alarm = alarm,
                            isEnabled = isEnabled
                        )
                    )
                }) {
                onViewEvent(YourAlarmsEvent.DeleteAlarm(alarm = it))
            }
        }
    }
}

@Composable
fun AlarmsList(
    alarms: List<AlarmDomain>,
    onAlarmCheckChange: (AlarmDomain, Boolean) -> Unit,
    onDeleteAlarm: (AlarmDomain) -> Unit
) {
    val state = rememberLazyListState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 16.dp,
        ),
        state = state
    ) {
        items(alarms, key = { it.alarmId }) { alarmItem ->
            AlarmItem(alarm = alarmItem,
                onCheckedChange = {
                    onAlarmCheckChange(alarmItem, it)
                }) {
                onDeleteAlarm(it)
            }
        }
    }
}
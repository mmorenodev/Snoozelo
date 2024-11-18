package dev.mmoreno.snoozelo.ui.your_alarms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewModelScope
import dev.mmoreno.snoozelo.domain.AlarmDomain
import dev.mmoreno.snoozelo.domain.AlarmRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class YourAlarmsViewModel(
    private val repository: AlarmRepository
) : ViewModel() {

    val uiState = repository
        .getAlarms()
        .flatMapLatest {
            flowOf(YourAlarmsUiState(alarms = it))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = YourAlarmsUiState()
        )

    fun onEvent(event: YourAlarmsEvent) = viewModelScope.launch {
        when (event) {
            is YourAlarmsEvent.DeleteAlarm -> {
                repository.deleteAlarm(event.alarm)
            }

            is YourAlarmsEvent.EnableDisableAlarm -> {
                repository.saveAlarm(event.alarm.copy(isEnabled = event.isEnabled))
            }

            is YourAlarmsEvent.SaveAlarm -> {
                repository.saveAlarm(event.alarm)
            }
        }
    }

    suspend fun saveAlarm(title: String, time: String) {
        repository.saveAlarm(
            AlarmDomain(
                title = title,
                time = time
            )
        )
    }
}

data class YourAlarmsUiState(
    val alarms: List<AlarmDomain> = emptyList()
) {
    val shouldShowEmptyState = alarms.isEmpty()
}

sealed interface YourAlarmsEvent {
    val alarm: AlarmDomain

    data class SaveAlarm(override val alarm: AlarmDomain) : YourAlarmsEvent
    data class DeleteAlarm(override val alarm: AlarmDomain) : YourAlarmsEvent
    data class EnableDisableAlarm(
        override val alarm: AlarmDomain,
        val isEnabled: Boolean
    ) : YourAlarmsEvent

}
package dev.mmoreno.snoozelo.domain

data class AlarmDomain(
    val alarmId: Long = 0L,
    val title: String,
    val time: String,
    val isEnabled: Boolean = true
)
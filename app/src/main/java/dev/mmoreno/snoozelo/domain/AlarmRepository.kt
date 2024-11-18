package dev.mmoreno.snoozelo.domain

import kotlinx.coroutines.flow.Flow

interface AlarmRepository {

    fun getAlarms(): Flow<List<AlarmDomain>>

    suspend fun saveAlarm(alarm: AlarmDomain)

    suspend fun deleteAlarm(alarm: AlarmDomain)

    suspend fun updateAlarm(alarm: AlarmDomain)
}
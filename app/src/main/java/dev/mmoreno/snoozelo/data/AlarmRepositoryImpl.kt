package dev.mmoreno.snoozelo.data

import dev.mmoreno.snoozelo.data.entities.AlarmEntity
import dev.mmoreno.snoozelo.data.entities.toDomain
import dev.mmoreno.snoozelo.domain.AlarmDomain
import dev.mmoreno.snoozelo.domain.AlarmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class AlarmRepositoryImpl(
    private val dao: AlarmDao
) : AlarmRepository {

    override fun getAlarms(): Flow<List<AlarmDomain>> {
        return dao.getAlarms().map {
            it.toDomain()
        }
    }


    override suspend fun saveAlarm(alarm: AlarmDomain) {
        with(alarm) {
            dao.saveAlarm(
                AlarmEntity(
                    id = alarmId,
                    name = title,
                    time = time,
                    isEnabled = isEnabled
                )
            )
        }
    }

    override suspend fun deleteAlarm(alarm: AlarmDomain) {
        dao.deleteAlarm(alarm.alarmId)
    }

    override suspend fun updateAlarm(alarm: AlarmDomain) {
        with(alarm) {
            dao.saveAlarm(
                AlarmEntity(
                    id = alarmId,
                    name = title,
                    time = time,
                    isEnabled = isEnabled
                )
            )
        }
    }
}
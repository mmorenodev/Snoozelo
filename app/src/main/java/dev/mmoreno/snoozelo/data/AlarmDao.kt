package dev.mmoreno.snoozelo.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import dev.mmoreno.snoozelo.data.entities.AlarmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Query("Select * From AlarmEntity")
    fun getAlarms(): Flow<List<AlarmEntity>>

    @Upsert
    suspend fun saveAlarm(alarmEntity: AlarmEntity)

    @Query("Delete From AlarmEntity Where id = :alarmId")
    suspend fun deleteAlarm(alarmId: Long)

}
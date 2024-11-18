package dev.mmoreno.snoozelo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.mmoreno.snoozelo.domain.AlarmDomain

@Entity
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L, // Let room automatically handle the ID
    val name: String,
    val time: String,
    val isEnabled: Boolean = true
)

fun List<AlarmEntity>.toDomain() = this.map {
    AlarmDomain(
        alarmId = it.id,
        title = it.name,
        time = it.time,
        isEnabled = it.isEnabled
    )
}



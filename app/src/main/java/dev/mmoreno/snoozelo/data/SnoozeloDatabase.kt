package dev.mmoreno.snoozelo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.mmoreno.snoozelo.data.entities.AlarmEntity

const val DATABASE_NAME = "Snoozelo_DB"

@Database(version = 1, entities = [AlarmEntity::class])
abstract class SnoozeloDatabase : RoomDatabase() {
    abstract val dao: AlarmDao
}
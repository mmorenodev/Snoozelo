package dev.mmoreno.snoozelo.di

import androidx.room.Room
import dev.mmoreno.snoozelo.data.AlarmDao
import dev.mmoreno.snoozelo.data.AlarmRepositoryImpl
import dev.mmoreno.snoozelo.data.DATABASE_NAME
import dev.mmoreno.snoozelo.data.SnoozeloDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import dev.mmoreno.snoozelo.domain.AlarmRepository
import dev.mmoreno.snoozelo.ui.your_alarms.YourAlarmsViewModel
import org.koin.core.module.dsl.viewModel

val appModule = module {

    single<SnoozeloDatabase> {
        Room.databaseBuilder(
            context = androidContext(),
            klass = SnoozeloDatabase::class.java,
            name = DATABASE_NAME
        ).build()
    }

    single<AlarmRepository> {
        AlarmRepositoryImpl(dao = get())
    }

    single<AlarmDao> {
        get<SnoozeloDatabase>().dao
    }

    viewModel {
        YourAlarmsViewModel(repository = get())
    }
}
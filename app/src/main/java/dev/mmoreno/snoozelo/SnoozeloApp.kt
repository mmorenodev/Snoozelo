package dev.mmoreno.snoozelo

import android.app.Application
import dev.mmoreno.snoozelo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SnoozeloApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SnoozeloApp)
            modules(appModule)
        }
    }
}
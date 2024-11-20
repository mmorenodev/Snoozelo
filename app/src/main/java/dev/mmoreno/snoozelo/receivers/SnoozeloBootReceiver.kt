package dev.mmoreno.snoozelo.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class SnoozeloBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            println("The device has booted up!")
            // TODO: Handle alarms logic
        }
    }
}
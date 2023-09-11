package com.example.shoppingapp.utils

import android.app.Activity
import android.util.Log
import androidx.activity.ComponentActivity

/**
 * Not confident with this implementation, just wanted to demonstrate the idea
 */
class ActivityChangeListener : ComponentActivity() {
    var currentActivity: Activity? = null

    // Override the onCreate method to log activity changes
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityChangeListener", "Activity Created: $this")
        currentActivity = this
    }

    fun startMonitoring() {
        currentActivity = this
    }

    fun stopMonitoring() {
        currentActivity = null
    }
}

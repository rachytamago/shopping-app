package com.example.shoppingapp.utils

import android.app.Activity
import android.util.Log
import androidx.activity.ComponentActivity

/**
 * Not confident with this implementation, just wanted to demonstrate the idea
 */
class ActivityChangeListener : ComponentActivity() {
    // Makes it possible to get the activity from the rule
    var currentActivity: Activity? = null

    // Override the onCreate method to log activity changes
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityChangeListener", "Activity Created: $this")
        currentActivity = this
    }

    // Set currentActivity in case `onCreate` was called before listener init
    fun startMonitoring() {
        currentActivity = this
    }
}

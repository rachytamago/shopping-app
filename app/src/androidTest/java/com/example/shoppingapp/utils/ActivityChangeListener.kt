package com.example.shoppingapp.utils

import android.app.Activity
import android.util.Log
import androidx.activity.ComponentActivity

/**
 * Not confident with this implementation, just wanted to demonstrate the idea
 */
class ActivityChangeListener : ComponentActivity() {
    companion object {
        const val TAG = "ActivityChangeListener"
    }
    // Makes it possible to get the activity from the rule
    var currentActivity: Activity? = null

    // Override the onCreate method to log activity changes
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Activity Created: $this")
        currentActivity = this
    }

    // Override the onStart method to log when the test starts the activity
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity Started: $this")
        currentActivity = this
    }

     // Override the onStart method to log when the test returns to the activity
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity Resumed: $this")
        currentActivity = this
    }

    // Set currentActivity in case `onCreate` was called before listener init
    fun startMonitoring() {
        currentActivity = this
    }
}

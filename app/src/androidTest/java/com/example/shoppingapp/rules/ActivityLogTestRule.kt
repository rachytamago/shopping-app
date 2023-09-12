package com.example.shoppingapp.rules

import android.app.Activity
import com.example.shoppingapp.utils.ActivityChangeListener
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * A rule to log the activity every time it is created
 */
class ActivityLogTestRule : TestRule {
    private var activityChangeListener: ActivityChangeListener? = ActivityChangeListener()

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                // Start monitoring activity changes
                activityChangeListener?.startMonitoring()
                try {
                    base.evaluate()
                } finally {
                    // Stop monitoring activity changes
                    activityChangeListener = null
                }
            }
        }
    }

    fun getActivity(): Activity? = activityChangeListener?.currentActivity
}

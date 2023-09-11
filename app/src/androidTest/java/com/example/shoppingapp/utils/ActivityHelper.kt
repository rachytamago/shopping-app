package com.example.shoppingapp.utils

import android.app.Activity
import org.junit.Assert.assertSame

internal fun assertActivity(currentActivity: Activity, expectedActivity: String) {
    assertSame(currentActivity::class.java.simpleName, expectedActivity)
}

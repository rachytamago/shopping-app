package com.example.shoppingapp.tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.shoppingapp.MainActivity
import com.example.shoppingapp.rules.ActivityLogTestRule
import org.junit.Rule

open class BaseTest {

    @get:Rule(order = 0)
    val activityLogRule = ActivityLogTestRule()

    @get:Rule(order = 1)
    val composeActivityRule = createAndroidComposeRule<MainActivity>() // assuming login is the main activity
}

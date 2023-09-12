package com.example.shoppingapp.screens.toolbar

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText

internal class ToolbarActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val toolbarElements by lazy { ToolbarElements(testRule) }

    fun clickCartButton() = toolbarElements.cartButton.performClick()

    fun assertCartBadgeCount(count: Int) {
        with(testRule) {
            toolbarElements.apply {
                cartButton.assertIsDisplayed()
                waitUntilElementHasText(cartBadge, count.toString())
            }
        }
    }

    fun assertCartBadgeNotDisplayed() = toolbarElements.cartBadge.assertIsNotDisplayed()
}

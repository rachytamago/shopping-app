package com.example.shoppingapp.screens.toolbar

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText

internal class ToolbarActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val toolbarElements by lazy { ToolbarElements }

    fun clickCartButton() =
        testRule.onNodeWithTag(toolbarElements.cartButton).performClick()

    fun assertCartBadgeCount(count: Int) {
        with(testRule) {
            toolbarElements.apply {
                onNodeWithTag(cartButton).assertIsDisplayed()
                waitUntilElementHasText(cartBadge, count.toString())
            }
        }
    }

    fun assertCartBadgeNotDisplayed() =
        testRule.onNodeWithTag(toolbarElements.cartBadge).assertIsNotDisplayed()
}

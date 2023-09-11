package com.example.shoppingapp.screens.toolbar

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText

internal class ToolbarActions(private val testRule: ComposeContentTestRule) {
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

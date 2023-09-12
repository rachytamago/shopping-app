package com.example.shoppingapp.screens.toolbar

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag

internal class ToolbarElements(testRule: ComposeContentTestRule) {

    val cartButton = testRule.onNodeWithTag("cart_button")
    val cartBadge = testRule.onNodeWithTag("cart_badge")
}

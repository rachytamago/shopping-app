package com.example.shoppingapp.screens.showcase

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag

internal class ShowcaseElements(testRule: ComposeContentTestRule) {

    val productsTitle = testRule.onNodeWithTag("products_title")
    val showcaseItem = testRule.onAllNodesWithTag("showcase_item")

    val productsString = "Products"
}

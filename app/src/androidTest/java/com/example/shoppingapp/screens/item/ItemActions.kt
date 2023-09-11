package com.example.shoppingapp.screens.item

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElement
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementWithTagExists

internal class ItemActions(private val testRule: ComposeContentTestRule) {
    private val itemElements by lazy { ItemElements }

    fun clickAddToCartButton() =
        testRule.onNodeWithTag(itemElements.addToCartButton).performClick()

    fun getItemName(): String = testRule.getTextOfElement(itemElements.itemTitle)

    fun assertItemScreenDisplayed() {
        with(testRule) {
            itemElements.apply {
                waitUntilElementHasText(backToProductsButton, backToProductsString)
                waitUntilElementWithTagExists(itemImage) // Assert only one item is displayed (cannot be on showcase screen)
                onNodeWithTag(itemTitle).assertIsDisplayed()
                onNodeWithTag(itemDescription).assertIsDisplayed()
                onNodeWithTag(itemPrice).assertTextContains(Currency.DOLLAR.symbol)
                onNodeWithTag(addToCartButton).assertTextEquals(addToCartString)
            }
        }
    }
}

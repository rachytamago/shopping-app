package com.example.shoppingapp.screens.cart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElementAtIndex
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilAtLeastOneElementWithTextExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText

internal class CartActions(private val testRule: ComposeContentTestRule) {
    private val cartElements by lazy { CartElements }

    fun clickCheckoutButton() =
        testRule.onNodeWithTag(cartElements.checkoutButton).performClick()

    fun assertCartScreenDisplayed() {
        with(testRule) {
            cartElements.apply {
                waitUntilElementHasText(yourCartTitle, yourCartString)
                waitUntilElementHasText(continueShoppingButton, continueShoppingString)
                onNodeWithText(checkoutButton).assertTextEquals(checkoutString)
                onNodeWithText(quantityHeading).assertTextEquals(quantityShortString)
                onNodeWithText(descriptionHeading).assertTextEquals(descriptionString)
            }
        }
    }

    fun assertCartItemCount(count: Int) {
        with(testRule) {
            cartElements.apply {
                waitUntilAtLeastOneElementWithTextExists(cartListItem)
                for (item in 0 until count) {
                    onAllNodesWithTag(cartItemTitle)[item].assertIsDisplayed()
                    onAllNodesWithTag(cartItemDescription)[item].assertIsDisplayed()
                    onAllNodesWithTag(cartItemPrice)[item].assertTextContains(Currency.DOLLAR.symbol)
                    onAllNodesWithTag(cartItemRemoveButton)[item].assertTextEquals(removeString)
                }
            }
        }
    }

    /**
     * The quantity of items in the order they were added.
     * Example usage for 1 of the first item and 3 of the second:
     * `assertCartItemQuantities(mutableMapOf("first item" to 1, "second item" to 3))`
     */
    fun assertCartItemQuantities(itemQuantities: Map<String, Int>) {
        with(testRule) {
            cartElements.apply {
                waitUntilAtLeastOneElementWithTextExists(cartListItem)
                // Check the quantity of each item based on the item name
                for (itemIndex in 0 until itemQuantities.size) {
                    val itemName: String = getTextOfElementAtIndex(cartItemDescription, itemIndex)
                    if (itemQuantities.containsKey(itemName)) {
                        // Assert the quantity for that item is correct
                        onAllNodesWithTag(cartItemQuantity)[itemIndex]
                            .assertTextContains(itemQuantities[itemName].toString())
                    }
                }
            }
        }
    }
}

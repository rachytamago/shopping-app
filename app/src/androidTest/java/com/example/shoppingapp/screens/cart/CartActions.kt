package com.example.shoppingapp.screens.cart

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElementAtIndex
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilAtLeastOneElementExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class CartActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val cartElements by lazy { CartElements(testRule) }

    fun clickCheckoutButton() = cartElements.checkoutButton.performClick()

    fun assertCartScreenDisplayed() {
        cartElements.apply {
            testRule.waitUntilElementHasText(yourCartTitle, yourCartString)
            testRule.waitUntilElementHasText(continueShoppingButton, continueShoppingString)
            assertActivity(testRule.activity, "CartActivity") // Would be CartActivity::class.java.simpleName, not a string
            checkoutButton.assertTextEquals(checkoutString)
            quantityHeading.assertTextEquals(quantityShortString)
            descriptionHeading.assertTextEquals(descriptionString)
        }
    }

    fun assertCartItemCount(count: Int) {
        cartElements.apply {
            testRule.waitUntilAtLeastOneElementExists(cartListItem)
            for (item in 0 until count) {
                cartItemTitle[item].assertIsDisplayed()
                cartItemDescription[item].assertIsDisplayed()
                cartItemPrice[item].assertTextContains(Currency.DOLLAR.symbol)
                cartItemRemoveButton[item].assertTextEquals(removeString)
            }
        }
    }

    /**
     * The quantity of items in the order they were added.
     * Example usage for 1 of the first item and 3 of the second:
     * `assertCartItemQuantities(mutableMapOf("first item" to 1, "second item" to 3))`
     */
    fun assertCartItemQuantities(itemQuantities: Map<String, Int>) {
        cartElements.apply {
            testRule.waitUntilAtLeastOneElementExists(cartListItem)
            // Check the quantity of each item based on the item name
            for (itemIndex in 0 until itemQuantities.size) {
                val itemName: String = getTextOfElementAtIndex(cartItemDescription, itemIndex)
                if (itemQuantities.containsKey(itemName)) {
                    // Assert the quantity for that item is correct
                    cartItemQuantity[itemIndex]
                        .assertTextEquals(itemQuantities[itemName].toString())
                }
            }
        }
    }
}

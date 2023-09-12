package com.example.shoppingapp.screens.cart

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag

internal class CartElements(testRule: ComposeContentTestRule) {

    val checkoutButton = testRule.onNodeWithTag("checkout_button")
    val continueShoppingButton = testRule.onNodeWithTag("continue_shopping_button")
    val quantityHeading = testRule.onNodeWithTag("quantity_heading")
    val descriptionHeading = testRule.onNodeWithTag("description_heading")
    val yourCartTitle = testRule.onNodeWithTag("your_cart_title")
    val cartListItem = testRule.onAllNodesWithTag("cart_list_item")
    val cartItemQuantity = testRule.onAllNodesWithTag("cart_item_quantity")
    val cartItemTitle = testRule.onAllNodesWithTag("cart_item_title")
    val cartItemDescription = testRule.onAllNodesWithTag("cart_item_description")
    val cartItemPrice = testRule.onAllNodesWithTag("cart_item_price")
    val cartItemRemoveButton = testRule.onAllNodesWithTag("remove_button")

    val checkoutString = "Checkout"
    val continueShoppingString = "Continue Shopping"
    val quantityShortString = "QTY"
    val yourCartString = "Your Cart"
    val removeString = "Remove"
    val descriptionString = "Description"
}

package com.example.shoppingapp.screens.item

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag

internal class ItemElements(testRule: ComposeContentTestRule) {

    val backToProductsButton = testRule.onNodeWithTag("back_to_products")
    val itemTitle = testRule.onAllNodesWithTag("item_title")
    val itemDescription = testRule.onAllNodesWithTag("item_description")
    val itemImage = testRule.onAllNodesWithTag("item_image")
    val itemPrice = testRule.onAllNodesWithTag("item_price")
    val addToCartButton = testRule.onAllNodesWithTag("add_to_cart_button")

    val backToProductsString = "Back to products"
    val addToCartString = "Add to cart"
}

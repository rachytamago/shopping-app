package com.example.shoppingapp.screens.item

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElement
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementWithTagExists
import com.example.shoppingapp.utils.assertActivity

internal class ItemActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val itemElements by lazy { ItemElements }

    fun clickAddToCartButton() =
        testRule.onNodeWithTag(itemElements.addToCartButton).performClick()

    fun getItemName(): String = testRule.getTextOfElement(itemElements.itemTitle)

    fun assertItemScreenDisplayed() {
        with(testRule) {
            itemElements.apply {
                waitUntilElementHasText(backToProductsButton, backToProductsString)
                waitUntilElementWithTagExists(itemImage) // Assert only one item is displayed (cannot be on showcase screen)
                assertActivity(activity, "ItemActivity") // Would be ItemActivity::class.java.simpleName, not a string
                onNodeWithTag(itemTitle).assertIsDisplayed()
                onNodeWithTag(itemDescription).assertIsDisplayed()
                onNodeWithTag(itemPrice).assertTextContains(Currency.DOLLAR.symbol)
                onNodeWithTag(addToCartButton).assertTextEquals(addToCartString)
            }
        }
    }
}

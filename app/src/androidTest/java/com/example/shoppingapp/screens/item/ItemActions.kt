package com.example.shoppingapp.screens.item

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElement
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class ItemActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val itemElements by lazy { ItemElements(testRule) }

    fun clickAddToCartButton() = itemElements.addToCartButton.onFirst().performClick()

    fun getItemName(): String = getTextOfElement(itemElements.itemTitle.onFirst())

    fun assertItemScreenDisplayed() {
        itemElements.apply {
            testRule.waitUntilElementHasText(backToProductsButton, backToProductsString)
            testRule.waitUntilElementExists(itemImage) // Assert only one item is displayed (cannot be on showcase screen)
            assertActivity(testRule.activity, "ItemActivity") // Would be ItemActivity::class.java.simpleName, not a string
            itemTitle.onFirst().assertIsDisplayed()
            itemDescription.onFirst().assertIsDisplayed()
            itemPrice.onFirst().assertTextContains(Currency.DOLLAR.symbol)
            addToCartButton.onFirst().assertTextEquals(addToCartString)
        }
    }
}

package com.example.shoppingapp.screens.showcase

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.screens.item.ItemElements
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElementAtIndex
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilAtLeastOneElementWithTagExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class ShowcaseActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val showcaseElements by lazy { ShowcaseElements }
    private val itemElements by lazy { ItemElements }

    fun clickShowcaseItemTitleAtIndex(index: Int) {
        testRule.onAllNodesWithTag(itemElements.itemTitle)[index].performClick()
    }

    fun addShowcaseItemToCartAtIndex(index: Int) {
        testRule.onAllNodesWithTag(itemElements.addToCartButton)[index].performClick()
    }

    fun getShowcaseItemNameAtIndex(index: Int): String =
        testRule.getTextOfElementAtIndex(itemElements.itemTitle, index)

    fun assertShowcaseItemDisplayedAtIndex(index: Int) {
        with(testRule) {
            showcaseElements.apply {
                waitUntilElementHasText(productsTitle, productsString)
                waitUntilAtLeastOneElementWithTagExists(showcaseItem)
            }
            assertActivity(activity, "ShowcaseActivity") // Would be ShowcaseActivity::class.java.simpleName, not a string
            // Assumed item tags are shared so can be reused to check showcase item elements
            itemElements.apply {
                onAllNodesWithTag(itemImage)[index].assertIsDisplayed()
                onAllNodesWithTag(itemTitle)[index].assertIsDisplayed()
                onAllNodesWithTag(itemDescription)[index].assertIsDisplayed()
                onAllNodesWithTag(itemImage)[index].assertIsDisplayed()
                onAllNodesWithTag(itemPrice)[index].assertTextContains(Currency.DOLLAR.symbol)
                onAllNodesWithTag(addToCartButton)[index].assertTextEquals(addToCartString)
            }
        }
    }
}

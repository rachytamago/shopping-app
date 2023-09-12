package com.example.shoppingapp.screens.showcase

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.screens.item.ItemElements
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElementAtIndex
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilAtLeastOneElementExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class ShowcaseActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val showcaseElements by lazy { ShowcaseElements(testRule) }
    private val itemElements by lazy { ItemElements(testRule) }

    fun clickShowcaseItemTitleAtIndex(index: Int) {
        itemElements.itemTitle[index].performClick()
    }

    fun addShowcaseItemToCartAtIndex(index: Int) {
        itemElements.addToCartButton[index].performClick()
    }

    fun getShowcaseItemNameAtIndex(index: Int): String =
        getTextOfElementAtIndex(itemElements.itemTitle, index)

    fun assertShowcaseItemDisplayedAtIndex(index: Int) {
        showcaseElements.apply {
            testRule.waitUntilElementHasText(productsTitle, productsString)
            testRule.waitUntilAtLeastOneElementExists(showcaseItem)
        }
        assertActivity(testRule.activity, "ShowcaseActivity") // Would be ShowcaseActivity::class.java.simpleName, not a string
        // Assumed item tags are shared so can be reused to check showcase item elements
        itemElements.apply {
            itemImage[index].assertIsDisplayed()
            itemTitle[index].assertIsDisplayed()
            itemDescription[index].assertIsDisplayed()
            itemImage[index].assertIsDisplayed()
            itemPrice[index].assertTextContains(Currency.DOLLAR.symbol)
            addToCartButton[index].assertTextEquals(addToCartString)
        }
    }
}

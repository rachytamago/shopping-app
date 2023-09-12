package com.example.shoppingapp.screens.checkout

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.screens.common.CommonElements
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class CheckoutActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val checkoutElements by lazy { CheckoutElements(testRule) }
    private val commonElements by lazy { CommonElements(testRule) }

    fun clickFinishButton() = commonElements.finishButton.performClick()

    fun assertCheckoutInfoDisplayed() {
        checkoutElements.apply {
            testRule.waitUntilElementHasText(checkoutOverviewHeading, overviewString)
            testRule.waitUntilElementHasText(paymentInfoTitle, paymentInfoString)
            assertActivity(testRule.activity, "CheckoutInfoActivity") // Would be CheckoutInfoActivity::class.java.simpleName, not a string
            paymentInfo.assertIsDisplayed()
            shippingInfoTitle.assertTextEquals(shippingInfoString)
            shippingInfo.assertIsDisplayed()
            priceTotalTitle.assertTextEquals(priceTotalString)
            itemTotal.assertTextContains(itemTotalString)
            taxTotal.assertTextContains(taxString)
            overallTotalPrice.assertTextContains(overallTotalString)
            overallTotalPrice.assertTextContains(Currency.DOLLAR.symbol)
        }
        commonElements.apply {
            cancelButton.assertTextEquals(cancelString)
            finishButton.assertTextEquals(finishString)
        }
    }

    fun assertCheckoutCompleteScreenDisplayed() {
        checkoutElements.apply {
            testRule.waitUntilElementHasText(checkoutCompleteHeading, completeString)
            testRule.waitUntilElementExists(tickImage)
            assertActivity(testRule.activity, "CheckoutCompleteActivity") // Would be CheckoutCompleteActivity::class.java.simpleName, not a string
            thankYouTitle.assertTextEquals(thankYouString)
            orderDispatchedText.assertIsDisplayed()
        }
        commonElements.apply {
            homeButton.assertTextEquals(backHomeString)
        }
    }
}

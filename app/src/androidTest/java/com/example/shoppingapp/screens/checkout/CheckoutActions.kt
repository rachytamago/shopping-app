package com.example.shoppingapp.screens.checkout

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.shoppingapp.screens.common.CommonElements
import com.example.shoppingapp.utils.Currency
import com.example.shoppingapp.utils.WaitHelper.waitUntilAtLeastOneElementWithTagExists
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText

internal class CheckoutActions(private val testRule: ComposeContentTestRule) {
    private val checkoutElements by lazy { CheckoutElements }
    private val commonElements by lazy { CommonElements }

    fun clickFinishButton() =
        testRule.onNodeWithTag(checkoutElements.finishButton).performClick()

    fun assertCheckoutInfoDisplayed() {
        with(testRule) {
            checkoutElements.apply {
                waitUntilElementHasText(checkoutOverviewHeading, overviewString)
                waitUntilElementHasText(paymentInfoTitle, paymentInfoString)
                onNodeWithTag(paymentInfo).assertIsDisplayed()
                onNodeWithTag(shippingInfoTitle).assertTextEquals(shippingInfoString)
                onNodeWithTag(shippingInfo).assertIsDisplayed()
                onNodeWithTag(priceTotalTitle).assertTextEquals(priceTotalString)
                onNodeWithTag(itemTotal).assertTextContains(itemTotalString)
                onNodeWithTag(taxTotal).assertTextContains(taxString)
                onNodeWithTag(overallTotalPrice).assertTextContains(overallTotalString)
                onNodeWithTag(overallTotalPrice).assertTextContains(Currency.DOLLAR.symbol)
            }
            commonElements.apply {
                onNodeWithTag(cancelButton).assertTextEquals(cancelString)
                onNodeWithTag(finishButton).assertTextEquals(finishString)
            }
        }
    }

    fun assertCheckoutCompleteScreenDisplayed() {
        with(testRule) {
            checkoutElements.apply {
                waitUntilElementHasText(checkoutCompleteHeading, completeString)
                waitUntilAtLeastOneElementWithTagExists(tickImage)
                onNodeWithTag(thankYouTitle).assertTextEquals(thankYouString)
                onNodeWithTag(orderDispatchedText).assertIsDisplayed()
            }
            commonElements.apply {
                onNodeWithTag(homeButton).assertTextEquals(backHomeString)
            }
        }
    }
}

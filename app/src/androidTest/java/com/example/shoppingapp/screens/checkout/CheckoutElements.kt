package com.example.shoppingapp.screens.checkout

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag

internal class CheckoutElements(testRule: ComposeContentTestRule) {

    val checkoutOverviewHeading = testRule.onNodeWithTag("checkout_overview_heading")
    val checkoutCompleteHeading = testRule.onNodeWithTag("checkout_complete_heading")
    
    // Overview
    val paymentInfoTitle = testRule.onNodeWithTag("payment_info_title")
    val paymentInfo = testRule.onNodeWithTag("payment_info")
    val shippingInfoTitle = testRule.onNodeWithTag("shipping_info_title")
    val shippingInfo = testRule.onNodeWithTag("shipping_info")
    val priceTotalTitle = testRule.onNodeWithTag("price_total_title")
    val itemTotal = testRule.onNodeWithTag("item_total")
    val taxTotal = testRule.onNodeWithTag("tax_total")
    val overallTotalPrice = testRule.onNodeWithTag("overall_total_price")

    // Complete
    val tickImage = testRule.onAllNodesWithTag("tick_image")
    val thankYouTitle = testRule.onNodeWithTag("thank_you_title")
    val orderDispatchedText = testRule.onNodeWithTag("order_dispatched")

    // Strings
    val overviewString = "Checkout: Overview"
    val completeString = "Checkout: Complete!"
    val paymentInfoString = "Payment Information"
    val shippingInfoString = "Shipping Information"
    val priceTotalString = "Price Total"
    val itemTotalString = "Item total:"
    val taxString = "Tax:"
    val overallTotalString = "Total:"
    val thankYouString = "Thank you for your order"
}

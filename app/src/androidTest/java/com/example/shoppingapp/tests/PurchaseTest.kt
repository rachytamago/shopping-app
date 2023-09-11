package com.example.shoppingapp.tests

import androidx.test.espresso.Espresso.pressBack
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.shoppingapp.screens.address.AddressActions
import com.example.shoppingapp.screens.cart.CartActions
import com.example.shoppingapp.screens.checkout.CheckoutActions
import com.example.shoppingapp.screens.item.ItemActions
import com.example.shoppingapp.screens.login.LoginActions
import com.example.shoppingapp.screens.showcase.ShowcaseActions
import com.example.shoppingapp.screens.toolbar.ToolbarActions
import com.example.shoppingapp.utils.standardUser
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PurchaseTest: BaseTest() {

    private val loginActions = LoginActions(composeActivityRule)
    private val showcaseActions = ShowcaseActions(composeActivityRule)
    private val itemActions = ItemActions(composeActivityRule)
    private val toolbarActions = ToolbarActions(composeActivityRule)
    private val cartActions = CartActions(composeActivityRule)
    private val addressActions= AddressActions(composeActivityRule)
    private val checkoutActions = CheckoutActions(composeActivityRule)

    @Test
    fun userCanPurchaseItems() {
        // A map to keep track of items added to the cart and their quantities
        val cartItemQuantities = mutableMapOf<String, Int>()

        loginActions.apply {
            assertLoginScreenDisplayed()
            loginAsUser(standardUser)
        }

        // Add item to cart from item screen
        showcaseActions.apply {
            assertShowcaseItemDisplayedAtIndex(0)
            clickShowcaseItemTitleAtIndex(0)
        }
        itemActions.apply {
            assertItemScreenDisplayed()
            clickAddToCartButton()
            cartItemQuantities[getItemName()] = 1 // Added item once
        }
        toolbarActions.assertCartBadgeCount(1)

        // Return and add another item from showcase screen
        pressBack()
        showcaseActions.apply {
            assertShowcaseItemDisplayedAtIndex(1)
            addShowcaseItemToCartAtIndex(1)
            cartItemQuantities[getShowcaseItemNameAtIndex(1)] = 1 // Added item once
        }

        // Verify cart contents
        toolbarActions.apply {
            assertCartBadgeCount(cartItemQuantities.size)
            clickCartButton()
        }
        cartActions.apply {
            assertCartScreenDisplayed()
            assertCartItemCount(cartItemQuantities.size)
            assertCartItemQuantities(cartItemQuantities)
            clickCheckoutButton()
        }

        // Enter shipping details
        addressActions.apply {
            assertAddressScreenDisplayed()
            enterAddressDetails(standardUser)
            clickContinueButton()
        }

        // Confirm 2 items still displayed in checkout cart
        cartActions.apply {
            assertCartItemCount(cartItemQuantities.size)
            assertCartItemQuantities(cartItemQuantities)
        }

        // Confirm checkout and complete transaction
        checkoutActions.apply {
            assertCheckoutInfoDisplayed()
            clickFinishButton()
            assertCheckoutCompleteScreenDisplayed()
        }

        // Cart is now empty as transaction was completed
        toolbarActions.assertCartBadgeNotDisplayed()
    }
}

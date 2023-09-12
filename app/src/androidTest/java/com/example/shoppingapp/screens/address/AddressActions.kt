package com.example.shoppingapp.screens.address

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.screens.common.CommonElements
import com.example.shoppingapp.utils.UserDetails
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class AddressActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val addressElements by lazy { AddressElements }
    private val commonElements by lazy { CommonElements }

    fun enterAddressDetails(user: UserDetails) {
        with(testRule) {
            addressElements.apply {
                onNodeWithTag(firstNameField).performTextInput(user.firstName)
                onNodeWithTag(lastNameField).performTextInput(user.lastName)
                onNodeWithTag(postalCodeField).performTextInput(user.postalCode)
            }
        }
    }

    fun clickContinueButton() =
        testRule.onNodeWithTag(commonElements.continueButton).performClick()

    fun assertAddressScreenDisplayed() {
        with(testRule) {
            addressElements.apply {
                waitUntilElementHasText(yourInformationTitle, yourInformationString)
                waitUntilElementHasText(firstNameField, firstNameString)
                assertActivity(activity, "AddressActivity") // Would be AddressActivity::class.java.simpleName, not a string
                onNodeWithTag(lastNameField).assertTextEquals(lastNameString)
                onNodeWithTag(postalCodeField).assertTextEquals(postalCodeString)
            }
            commonElements.apply {
                onNodeWithTag(cancelButton).assertTextEquals(cancelString)
                onNodeWithTag(continueButton).assertTextEquals(continueString)
            }
        }
    }
}

package com.example.shoppingapp.screens.address

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
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
    private val addressElements by lazy { AddressElements(testRule) }
    private val commonElements by lazy { CommonElements(testRule) }

    fun enterAddressDetails(user: UserDetails) {
        addressElements.apply {
            firstNameField.performTextInput(user.firstName)
            lastNameField.performTextInput(user.lastName)
            postalCodeField.performTextInput(user.postalCode)
        }
    }

    fun clickContinueButton() = commonElements.continueButton.performClick()

    fun assertAddressScreenDisplayed() {
        addressElements.apply {
            testRule.waitUntilElementHasText(yourInformationTitle, yourInformationString)
            testRule.waitUntilElementHasText(firstNameField, firstNameString)
            assertActivity(testRule.activity, "AddressActivity") // Would be AddressActivity::class.java.simpleName, not a string
            lastNameField.assertTextEquals(lastNameString)
            postalCodeField.assertTextEquals(postalCodeString)
        }
        commonElements.apply {
            cancelButton.assertTextEquals(cancelString)
            continueButton.assertTextEquals(continueString)
        }
    }
}

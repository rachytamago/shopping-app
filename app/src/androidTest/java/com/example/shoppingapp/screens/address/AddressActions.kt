package com.example.shoppingapp.screens.address

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.shoppingapp.screens.common.CommonElements
import com.example.shoppingapp.utils.UserDetails
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText

internal class AddressActions(private val testRule: ComposeContentTestRule) {
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

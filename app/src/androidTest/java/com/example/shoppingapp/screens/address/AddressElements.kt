package com.example.shoppingapp.screens.address

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag

internal class AddressElements(testRule: ComposeContentTestRule) {

    val yourInformationTitle = testRule.onNodeWithTag("your_information_title")
    val firstNameField = testRule.onNodeWithTag("first_name_field")
    val lastNameField = testRule.onNodeWithTag("last_name_field")
    val postalCodeField = testRule.onNodeWithTag("postal_code_field")

    val yourInformationString = "Checkout: Your Information"
    val firstNameString = "First Name"
    val lastNameString = "Last Name"
    val postalCodeString = "Zip/Postal Code"
}

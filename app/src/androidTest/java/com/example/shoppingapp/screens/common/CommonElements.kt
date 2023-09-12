package com.example.shoppingapp.screens.common

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag

internal class CommonElements(testRule: ComposeContentTestRule) {

    val cancelButton = testRule.onNodeWithTag("cancel_button")
    val continueButton = testRule.onNodeWithTag("continue_button")
    val finishButton = testRule.onNodeWithTag("finish_button")
    val homeButton = testRule.onNodeWithTag("home_button")

    val cancelString = "Cancel"
    val continueString = "Continue"
    val finishString = "Finish"
    val backHomeString = "Back Home"
}

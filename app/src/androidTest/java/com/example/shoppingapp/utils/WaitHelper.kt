package com.example.shoppingapp.utils

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsNodeInteractionCollection
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.example.shoppingapp.utils.SemanticsPropertyHelper.getTextOfElement

internal object WaitHelper {

    private const val DEFAULT_TIMEOUT = 5_000L

    internal fun ComposeContentTestRule.waitUntilElementHasText(
        element: SemanticsNodeInteraction, text: String
    ) {
        this.waitUntil(DEFAULT_TIMEOUT) {
            getTextOfElement(element) == text
        }
    }

    // Element must be found using `onAllNodes...` to wait for a given number to exist
    internal fun ComposeContentTestRule.waitUntilElementExists(element: SemanticsNodeInteractionCollection) {
        this.waitUntil(DEFAULT_TIMEOUT) {
            element.fetchSemanticsNodes().size == 1
        }
    }

    // Element must be found using `onAllNodes...` to wait for a given number to exist
    internal fun ComposeContentTestRule.waitUntilAtLeastOneElementExists(element: SemanticsNodeInteractionCollection) {
        this.waitUntil(DEFAULT_TIMEOUT) {
            element.fetchSemanticsNodes().isNotEmpty()
        }
    }
}

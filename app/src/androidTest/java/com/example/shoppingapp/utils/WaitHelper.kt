package com.example.shoppingapp.utils

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag

internal object WaitHelper {

    private const val DEFAULT_TIMEOUT = 5_000L

    internal fun ComposeContentTestRule.waitUntilElementHasText(tag: String, text: String) {
        with(this) {
            waitUntil(DEFAULT_TIMEOUT) {
                onAllNodesWithText(text).fetchSemanticsNodes().size == 1
            }
            onNodeWithTag(tag).assertTextEquals(text)
        }
    }

    internal fun ComposeContentTestRule.waitUntilAtLeastOneElementWithTextExists(text: String) {
        with(this) {
            waitUntil(DEFAULT_TIMEOUT) {
                onAllNodesWithText(text).fetchSemanticsNodes().isNotEmpty()
            }
        }
    }

    internal fun ComposeContentTestRule.waitUntilElementWithTagExists(tag: String) {
        with(this) {
            waitUntil(DEFAULT_TIMEOUT) {
                onAllNodesWithTag(tag).fetchSemanticsNodes().size == 1
            }
        }
    }

    internal fun ComposeContentTestRule.waitUntilAtLeastOneElementWithTagExists(text: String) {
        with(this) {
            waitUntil(DEFAULT_TIMEOUT) {
                onAllNodesWithTag(text).fetchSemanticsNodes().isNotEmpty()
            }
        }
    }
}
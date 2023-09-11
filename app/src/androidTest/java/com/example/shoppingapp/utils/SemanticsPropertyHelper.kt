package com.example.shoppingapp.utils

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag

internal object SemanticsPropertyHelper {

    fun ComposeContentTestRule.getTextOfElement(tag: String): String {
        return onNodeWithTag(tag).fetchSemanticsNode()
            .config.getOrNull(SemanticsProperties.Text).toString()
    }

    fun ComposeContentTestRule.getTextOfElementAtIndex(
        tag: String, index: Int,
    ): String {
        return onAllNodesWithTag(tag)[index].fetchSemanticsNode()
            .config.getOrNull(SemanticsProperties.Text).toString()
    }
}

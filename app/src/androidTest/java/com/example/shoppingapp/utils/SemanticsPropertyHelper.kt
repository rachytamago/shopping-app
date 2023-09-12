package com.example.shoppingapp.utils

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.text.AnnotatedString

internal object SemanticsPropertyHelper {

    fun ComposeContentTestRule.getTextOfElement(tag: String): String {
        return annotatedStringListToString(
            onNodeWithTag(tag).fetchSemanticsNode()
            .config[SemanticsProperties.Text]
        )
    }

    fun ComposeContentTestRule.getTextOfElementAtIndex(tag: String, index: Int): String {
        return annotatedStringListToString(
            onAllNodesWithTag(tag)[index].fetchSemanticsNode()
                .config[SemanticsProperties.Text]
        )
    }

    private fun annotatedStringListToString(annotatedStringList: List<AnnotatedString>): String {
        return annotatedStringList.joinToString(separator = "") { it.text }
    }
}

package com.example.shoppingapp.utils

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsNodeInteractionCollection
import androidx.compose.ui.text.AnnotatedString

internal object SemanticsPropertyHelper {

    fun getTextOfElement(element: SemanticsNodeInteraction): String {
        return annotatedStringListToString(
            element.fetchSemanticsNode().config[SemanticsProperties.Text]
        )
    }

    fun getTextOfElementAtIndex(element: SemanticsNodeInteractionCollection, index: Int, ): String {
        return annotatedStringListToString(
            element[index].fetchSemanticsNode().config[SemanticsProperties.Text]
        )
    }

    private fun annotatedStringListToString(annotatedStringList: List<AnnotatedString>): String {
        return annotatedStringList.joinToString(separator = "") { it.text }
    }
}

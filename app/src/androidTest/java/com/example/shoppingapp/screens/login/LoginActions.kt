package com.example.shoppingapp.screens.login

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.MainActivity
import com.example.shoppingapp.utils.UserDetails
import com.example.shoppingapp.utils.WaitHelper.waitUntilAtLeastOneElementWithTagExists
import com.example.shoppingapp.utils.assertActivity

internal class LoginActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val loginElements by lazy { LoginElements }

    fun loginAsUser(user: UserDetails) {
        with(testRule) {
            loginElements.apply {
                onNodeWithTag(usernameField).performTextInput(user.username)
                onNodeWithTag(passwordField).performTextInput(user.password)
            }
        }
        tapLoginButton()
    }

    private fun tapLoginButton() =
        testRule.onNodeWithTag(loginElements.loginButton).performClick()

    fun assertLoginScreenDisplayed() {
        with(testRule) {
            loginElements.apply {
                waitUntilAtLeastOneElementWithTagExists(loginButton)
                assertActivity(activity, MainActivity::class.java.simpleName) // assuming login is the main activity
                onNodeWithTag(usernameField).assertTextEquals(usernameString)
                onNodeWithTag(passwordField).assertTextEquals(passwordString)
                onNodeWithTag(loginButton).assertTextEquals(loginString)
            }
        }
    }
}

package com.example.shoppingapp.screens.login

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.shoppingapp.MainActivity
import com.example.shoppingapp.utils.UserDetails
import com.example.shoppingapp.utils.WaitHelper.waitUntilElementHasText
import com.example.shoppingapp.utils.assertActivity

internal class LoginActions<A : ComponentActivity>(
    private val testRule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>
) {
    private val loginElements by lazy { LoginElements(testRule) }

    fun loginAsUser(user: UserDetails) {
        loginElements.apply {
            usernameField.performTextInput(user.username)
            passwordField.performTextInput(user.password)
        }
        tapLoginButton()
    }

    private fun tapLoginButton() = loginElements.loginButton.performClick()

    fun assertLoginScreenDisplayed() {
        loginElements.apply {
            testRule.waitUntilElementHasText(loginButton, loginString)
            assertActivity(testRule.activity, MainActivity::class.java.simpleName) // assuming login is the main activity
            usernameField.assertTextEquals(usernameString)
            passwordField.assertTextEquals(passwordString)
        }
    }
}

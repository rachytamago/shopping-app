package com.example.shoppingapp.screens.login

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag

internal class LoginElements(testRule: ComposeContentTestRule) {

    val usernameField = testRule.onNodeWithTag("username_field")
    val passwordField = testRule.onNodeWithTag("password_field")
    val loginButton = testRule.onNodeWithTag("login_button")

    val usernameString = "Username"
    val passwordString = "Password"
    val loginString = "Login"
}

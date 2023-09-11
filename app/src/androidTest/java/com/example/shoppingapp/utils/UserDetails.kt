package com.example.shoppingapp.utils

internal data class UserDetails (
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val postalCode: String,
    // Other user related details
)

internal val standardUser = UserDetails(
    username = "standard_user",
    password = "secret_sauce",
    firstName = "standard",
    lastName = "user",
    postalCode = "111-0011",
)
// Other user types

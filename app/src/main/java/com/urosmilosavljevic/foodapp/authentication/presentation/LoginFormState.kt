package com.urosmilosavljevic.foodapp.authentication.presentation

data class LoginFormState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val rememberMe: Boolean = false,
)

package com.urosmilosavljevic.foodapp.authentication.login.presentation

data class LoginFormState(
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val rememberMe: Boolean = false,
    val isLoading: Boolean? = false,
)

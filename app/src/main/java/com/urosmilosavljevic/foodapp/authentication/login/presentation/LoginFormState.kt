package com.urosmilosavljevic.foodapp.authentication.login.presentation

data class LoginFormState(
    val email: String = "",
    val emailErrorId: Int? = null,
    val password: String = "",
    val passwordErrorId: Int? = null,
    val rememberMe: Boolean = false,
    val isLoading: Boolean? = false,
)

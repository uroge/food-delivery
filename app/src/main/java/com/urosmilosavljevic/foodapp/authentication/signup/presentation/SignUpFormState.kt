package com.urosmilosavljevic.foodapp.authentication.signup.presentation

data class SignUpFormState(
    val name: String = "",
    val nameErrorId: Int? = null,
    val email: String = "",
    val emailErrorId: Int? = null,
    val password: String = "",
    val passwordErrorId: Int? = null,
    val confirmPassword: String = "",
    val confirmPasswordErrorId: Int? = null,
    val isLoading: Boolean? = false,
)

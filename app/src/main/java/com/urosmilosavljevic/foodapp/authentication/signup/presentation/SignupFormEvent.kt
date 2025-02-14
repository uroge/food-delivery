package com.urosmilosavljevic.foodapp.authentication.signup.presentation

sealed class SignupFormEvent {
    data class NameChanged(
        val name: String,
    ) : SignupFormEvent()

    data class EmailChanged(
        val email: String,
    ) : SignupFormEvent()

    data class PasswordChanged(
        val password: String,
    ) : SignupFormEvent()

    data class ConfirmPasswordChanged(
        val confirmPassword: String,
    ) : SignupFormEvent()

    data object Submit : SignupFormEvent()
}

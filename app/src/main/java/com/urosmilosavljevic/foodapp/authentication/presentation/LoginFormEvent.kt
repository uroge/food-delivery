package com.urosmilosavljevic.foodapp.authentication.presentation

sealed class LoginFormEvent {
    data class EmailChanged(
        val email: String,
    ) : LoginFormEvent()

    data class PasswordChanged(
        val password: String,
    ) : LoginFormEvent()

    data class RememberMeChanged(
        val shouldRemember: Boolean,
    ) : LoginFormEvent()

    data object Submit : LoginFormEvent()
}

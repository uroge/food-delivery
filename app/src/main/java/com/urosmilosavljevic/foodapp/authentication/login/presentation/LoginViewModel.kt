package com.urosmilosavljevic.foodapp.authentication.login.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidatePassword
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
) : ViewModel() {
    var state by mutableStateOf(LoginFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is LoginFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is LoginFormEvent.RememberMeChanged -> {
                state = state.copy(rememberMe = event.shouldRemember)
            }
            is LoginFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)

        val hasError =
            listOf(
                emailResult,
                passwordResult,
            ).any { !it.successful }

        if (hasError) {
            state =
                state.copy(
                    emailError = emailResult.errorMessage,
                    passwordError = passwordResult.errorMessage,
                )
            return
        } else {
            state =
                state.copy(
                    emailError = null,
                    passwordError = null,
                )
        }
        viewModelScope.launch {
            val result = authRepository.login(state.email, state.password)
            result
                .onSuccess { user ->
                    println("User: $user")
                    validationEventChannel.send(ValidationEvent.Success)
                }.onFailure { error ->
                    println("Error $error")
                }
        }
    }

    sealed class ValidationEvent {
        data object Success : ValidationEvent()
    }
}

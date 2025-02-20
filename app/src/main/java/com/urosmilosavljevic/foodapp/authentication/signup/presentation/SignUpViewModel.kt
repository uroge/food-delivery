package com.urosmilosavljevic.foodapp.authentication.signup.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidatePassword
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateConfirmPassword
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authRepository: AuthRepository,
    private val validateName: ValidateName,
    private val validateEmail: ValidateEmail,
    private val validatePassword: ValidatePassword,
    private val validateConfirmPassword: ValidateConfirmPassword,
) : ViewModel() {
    var state by mutableStateOf(SignUpFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: SignupFormEvent) {
        when (event) {
            is SignupFormEvent.NameChanged -> {
                state = state.copy(name = event.name)
            }
            is SignupFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is SignupFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is SignupFormEvent.ConfirmPasswordChanged -> {
                state = state.copy(confirmPassword = event.confirmPassword)
            }
            is SignupFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val nameResult = validateName.execute(state.name)
        val emailResult = validateEmail.execute(state.email)
        val passwordResult = validatePassword.execute(state.password)
        val confirmPasswordResult = validateConfirmPassword.execute(state.confirmPassword, state.password)

        val hasError =
            listOf(
                nameResult,
                emailResult,
                passwordResult,
                confirmPasswordResult,
            ).any { !it.successful }

        if (hasError) {
            state =
                state.copy(
                    nameError = nameResult.errorMessage,
                    emailError = emailResult.errorMessage,
                    passwordError = passwordResult.errorMessage,
                    confirmPasswordError = confirmPasswordResult.errorMessage,
                )
            return
        } else {
            state =
                state.copy(
                    nameError = null,
                    emailError = null,
                    passwordError = null,
                    confirmPasswordError = null,
                )
        }
        viewModelScope.launch {
            val result = authRepository.signUp(state.email, state.password, state.name)
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

package com.urosmilosavljevic.foodapp.authentication.signup.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAInputField
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun SignupForm(
    onSignupSuccess: () -> Unit,
    viewModel: SignUpViewModel,
) {
    val state = viewModel.state
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is SignUpViewModel.ValidationEvent.Success -> {
                    onSignupSuccess()
                }
            }
        }
    }

    Column {
        FAInputField(
            placeholder = "John Doe",
            value = state.name,
            label = "Name",
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(SignupFormEvent.NameChanged(it))
            },
            hasError = state.nameError != null,
            errorMessage = state.nameError,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
            keyboardActions =
                KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        FAInputField(
            placeholder = "example@gmail.com",
            value = state.email,
            label = "Email",
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(SignupFormEvent.EmailChanged(it))
            },
            hasError = state.emailError != null,
            errorMessage = state.emailError,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
            keyboardActions =
                KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        FAInputField(
            placeholder = "Password",
            label = "Password",
            value = state.password,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(SignupFormEvent.PasswordChanged(it))
            },
            hasError = state.passwordError != null,
            errorMessage = state.passwordError,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                ),
            keyboardActions =
                KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        FAInputField(
            placeholder = "Re-Type Password",
            label = "Re-Type password",
            value = state.confirmPassword,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(SignupFormEvent.ConfirmPasswordChanged(it))
            },
            hasError = state.confirmPasswordError != null,
            errorMessage = state.confirmPasswordError,
            keyboardActions =
                KeyboardActions(
                    onDone = {
                        viewModel.onEvent(SignupFormEvent.Submit)
                    },
                ),
        )
        Spacer(modifier = Modifier.height(32.dp))
        FAButton(
            text = "Sign Up".uppercase(),
            onClick = {
                viewModel.onEvent(SignupFormEvent.Submit)
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun PreviewSignupForm() {
    FoodAppTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            SignupForm({}, viewModel())
        }
    }
}

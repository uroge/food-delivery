package com.urosmilosavljevic.foodapp.authentication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.urosmilosavljevic.foodapp.authentication.presentation.LoginFormEvent
import com.urosmilosavljevic.foodapp.authentication.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.components.FACheckbox
import com.urosmilosavljevic.foodapp.core.ui.components.FAInputField
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun LoginForm(onLoginSuccess: () -> Unit) {
    val viewModel = viewModel<LoginViewModel>()
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is LoginViewModel.ValidationEvent.Success -> {
                    onLoginSuccess()
                }
            }
        }
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        FAInputField(
            placeholder = "example@gmail.com",
            value = state.email,
            label = "Email",
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
            type = KeyboardType.Email,
            onChange = {
                viewModel.onEvent(LoginFormEvent.EmailChanged(it))
            },
            hasError = state.emailError != null,
            errorMessage = state.emailError,
        )
        Spacer(modifier = Modifier.height(16.dp))
        FAInputField(
            placeholder = "Password",
            label = "Password",
            value = state.password,
            type = KeyboardType.Password,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(LoginFormEvent.PasswordChanged(it))
            },
            hasError = state.passwordError != null,
            errorMessage = state.passwordError,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            FACheckbox(
                checked = state.rememberMe,
                onCheckedChange = {
                    viewModel.onEvent(LoginFormEvent.RememberMeChanged(it))
                },
                label = "Remember me",
            )
            FAButton(
                text = "Forgot Password",
                onClick = {},
                type = FAButtonTypes.TEXT,
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        FAButton(
            text = "Log in",
            onClick = {
                viewModel.onEvent(LoginFormEvent.Submit)
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun LoginFormPreview() {
    FoodAppTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            LoginForm({})
        }
    }
}

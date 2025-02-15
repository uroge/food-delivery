package com.urosmilosavljevic.foodapp.authentication.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonDensity
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.components.FACheckbox
import com.urosmilosavljevic.foodapp.core.ui.components.FAInputField
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun LoginForm(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel,
) {
    val state = viewModel.state
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                is LoginViewModel.ValidationEvent.Success -> {
                    onLoginSuccess()
                }
            }
        }
    }

    Column {
        FAInputField(
            placeholder = stringResource(R.string.input_email_placeholder),
            value = state.email,
            label = stringResource(R.string.input_email_label),
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(LoginFormEvent.EmailChanged(it))
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
            placeholder = stringResource(R.string.input_password_placeholder),
            label = stringResource(R.string.input_password_label),
            value = state.password,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
            modifier = Modifier.fillMaxWidth(),
            onChange = {
                viewModel.onEvent(LoginFormEvent.PasswordChanged(it))
            },
            hasError = state.passwordError != null,
            errorMessage = state.passwordError,
            keyboardActions =
                KeyboardActions(
                    onDone = {
                        viewModel.onEvent(LoginFormEvent.Submit)
                    },
                ),
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
                label = stringResource(R.string.remember_me_checkbox),
            )
            FAButton(
                text = stringResource(R.string.forgot_password_link),
                onClick = {},
                type = FAButtonTypes.TEXT,
                density = FAButtonDensity.LOW,
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        FAButton(
            text = stringResource(R.string.login_button).uppercase(),
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
            LoginForm({}, viewModel())
        }
    }
}

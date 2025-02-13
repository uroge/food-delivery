package com.urosmilosavljevic.foodapp.authentication.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.urosmilosavljevic.foodapp.authentication.login.domain.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.login.domain.ValidatePassword
import com.urosmilosavljevic.foodapp.authentication.shared.AuthenticationScreenLayout
import com.urosmilosavljevic.foodapp.authentication.shared.SignUpOptions
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun LoginScreenRoot(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel,
) {
    LoginScreen(
        onLoginSuccess = onLoginSuccess,
        viewModel = viewModel,
    )
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    viewModel: LoginViewModel,
) {
    AuthenticationScreenLayout(
        title = "Log In",
        subtitle = "Please sign in to your existing account",
        primaryContent = {
            LoginForm(onLoginSuccess, viewModel = viewModel)
        },
        bottomContent = {
            SignUpOptions()
        },
    )
}

@Preview
@Composable
private fun LoginScreenPreview() {
    FoodAppTheme {
        LoginScreen(
            onLoginSuccess = {},
            viewModel =
                LoginViewModel(
                    validateEmail = ValidateEmail(),
                    validatePassword = ValidatePassword(),
                ),
        )
    }
}

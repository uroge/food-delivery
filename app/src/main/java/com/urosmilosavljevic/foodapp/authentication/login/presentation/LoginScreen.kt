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
    onSignupClick: () -> Unit,
    viewModel: LoginViewModel,
) {
    LoginScreen(
        onLoginSuccess = onLoginSuccess,
        viewModel = viewModel,
        onSignupClick = onSignupClick,
    )
}

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onSignupClick: () -> Unit,
    viewModel: LoginViewModel,
) {
    AuthenticationScreenLayout(
        title = "Log In",
        subtitle = "Please sign in to your existing account",
        primaryContent = {
            LoginForm(onLoginSuccess, viewModel = viewModel)
        },
        bottomContent = {
            SignUpOptions(onSignupClick)
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
            onSignupClick = {},
        )
    }
}

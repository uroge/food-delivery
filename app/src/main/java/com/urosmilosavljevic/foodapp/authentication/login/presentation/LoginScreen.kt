package com.urosmilosavljevic.foodapp.authentication.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.authentication.shared.AuthenticationScreenLayout
import com.urosmilosavljevic.foodapp.authentication.shared.SignUpOptions
import com.urosmilosavljevic.foodapp.authentication.shared.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.shared.ValidatePassword
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
        title = stringResource(R.string.login_screen_title),
        subtitle = stringResource(R.string.login_screen_subtitle),
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

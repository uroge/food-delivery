package com.urosmilosavljevic.foodapp.authentication.login.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.authentication.shared.presentation.AuthenticationScreenLayout
import com.urosmilosavljevic.foodapp.authentication.shared.presentation.SignUpOptions
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onSignupClick: () -> Unit,
    viewModel: LoginViewModel = koinViewModel(),
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
            viewModel = viewModel(),
            onSignupClick = {},
        )
    }
}

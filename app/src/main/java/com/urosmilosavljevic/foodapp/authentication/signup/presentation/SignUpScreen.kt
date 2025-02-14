package com.urosmilosavljevic.foodapp.authentication.signup.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.urosmilosavljevic.foodapp.authentication.shared.AuthenticationScreenLayout
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun SignUpScreen(
    onGoBack: () -> Unit,
    onSignupSuccess: () -> Unit,
    viewModel: SignUpViewModel,
) {
    AuthenticationScreenLayout(
        title = "Sign Up",
        subtitle = "Please sign up to get started",
        onGoBack = onGoBack,
        primaryContent = {
            SignupForm(onSignupSuccess, viewModel)
        },
    )
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    FoodAppTheme {
        SignUpScreen(
            onGoBack = {},
            onSignupSuccess = {},
            viewModel = viewModel(),
        )
    }
}

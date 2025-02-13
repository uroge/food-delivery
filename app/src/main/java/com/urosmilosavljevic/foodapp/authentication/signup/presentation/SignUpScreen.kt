package com.urosmilosavljevic.foodapp.authentication.signup.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.urosmilosavljevic.foodapp.authentication.shared.AuthenticationScreenLayout
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun SignUpScreen() {
    AuthenticationScreenLayout(
        title = "Sign Up",
        subtitle = "Please sign up to get started",
        primaryContent = {
            SignupForm()
        },
    )
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    FoodAppTheme {
        SignUpScreen()
    }
}

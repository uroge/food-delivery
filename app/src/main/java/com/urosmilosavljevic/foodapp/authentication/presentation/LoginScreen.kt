package com.urosmilosavljevic.foodapp.authentication.presentation

import androidx.compose.runtime.Composable
import com.urosmilosavljevic.foodapp.authentication.presentation.components.LoginForm

@Composable
fun LoginScreenRoot(onLoginSuccess: () -> Unit) {
    LoginScreen(onLoginSuccess = onLoginSuccess)
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    LoginForm(onLoginSuccess)
}

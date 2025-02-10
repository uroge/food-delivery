package com.urosmilosavljevic.foodapp.authentication.presentation

import androidx.compose.runtime.Composable
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton

@Composable
fun LoginScreenRoot(onLoginSuccess: () -> Unit) {
    LoginScreen(onLoginSuccess = onLoginSuccess)
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    FAButton(
        text = "Go back",
        onClick = onLoginSuccess,
    )
}

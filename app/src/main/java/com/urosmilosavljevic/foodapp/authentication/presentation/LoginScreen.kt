package com.urosmilosavljevic.foodapp.authentication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.authentication.presentation.components.AuthenticationScreenTitle
import com.urosmilosavljevic.foodapp.authentication.presentation.components.LoginForm
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun LoginScreenRoot(onLoginSuccess: () -> Unit) {
    LoginScreen(onLoginSuccess = onLoginSuccess)
}

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary),
    ) {
        AuthenticationScreenTitle(
            title = "Log In",
            subtitle = "Please sign in to your existing account",
        )
        Box(
            modifier =
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(MaterialTheme.colorScheme.background),
        ) {
            Box(modifier = Modifier.padding(24.dp)) {
                LoginForm(onLoginSuccess)
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    FoodAppTheme {
        LoginScreen(onLoginSuccess = {})
    }
}

package com.urosmilosavljevic.foodapp.authentication.signup.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.authentication.shared.presentation.AuthenticationScreenLayout
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    onGoBack: () -> Unit,
    onSignupSuccess: () -> Unit,
    viewModel: SignUpViewModel = koinViewModel(),
) {
    AuthenticationScreenLayout(
        title = stringResource(R.string.sign_up_screen_title),
        subtitle = stringResource(R.string.sign_up_screen_subtitle),
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

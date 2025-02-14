package com.urosmilosavljevic.foodapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginScreenRoot
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpScreen
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpViewModel
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingScreenRoot
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FAAppNavigation(startDestination: FARoute) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<FARoute.Root> {
            val viewModel: OnboardingViewModel = koinViewModel()
            OnboardingScreenRoot(
                viewModel = viewModel,
                onOnboardingFinished = {
                    navController.navigate(FARoute.Login)
                },
            )
        }
        composable<FARoute.Login> {
            val viewModel: LoginViewModel = koinViewModel()
            LoginScreenRoot(
                onLoginSuccess = {
                    // TODO: Implement navigation to the next screen
                    navController.navigateUp()
                },
                viewModel = viewModel,
                onSignupClick = {
                    navController.navigate(FARoute.SignUp)
                },
            )
        }
        composable<FARoute.SignUp> {
            val viewModel: SignUpViewModel = koinViewModel()
            SignUpScreen(
                onGoBack = {
                    navController.navigateUp()
                },
                onSignupSuccess = {
                    // TODO: Implement navigation to next screen
                },
                viewModel = viewModel,
            )
        }
    }
}

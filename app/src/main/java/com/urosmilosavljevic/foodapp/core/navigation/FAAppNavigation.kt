package com.urosmilosavljevic.foodapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.urosmilosavljevic.foodapp.authentication.presentation.LoginScreenRoot
import com.urosmilosavljevic.foodapp.authentication.presentation.LoginViewModel
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
                    navController.navigateUp()
                },
                viewModel = viewModel,
            )
        }
    }
}

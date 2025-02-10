package com.urosmilosavljevic.foodapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.urosmilosavljevic.foodapp.authentication.presentation.LoginScreenRoot
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingScreenRoot
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel

@Composable
fun FAAppNavigation(
    startDestination: FARoute,
    preferences: OnboardingPreferences,
) {
    val navController = rememberNavController()

    // TODO: Handle DI
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable<FARoute.Root> {
            OnboardingScreenRoot(
                viewModel = OnboardingViewModel(preferences),
                onOnboardingFinished = {
                    navController.navigate(FARoute.Login)
                },
            )
        }
        composable<FARoute.Login> {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigateUp()
                },
            )
        }
    }
}

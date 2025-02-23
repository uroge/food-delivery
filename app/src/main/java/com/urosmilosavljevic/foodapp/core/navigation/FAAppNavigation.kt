package com.urosmilosavljevic.foodapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginScreen
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpScreen
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpViewModel
import com.urosmilosavljevic.foodapp.home.presentation.HomeScreen
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingScreenRoot
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FAAppNavigation(
    startDestination: FARoute,
    authRepository: AuthRepository,
) {
    val navController = rememberNavController()
    val authState = authRepository.authState.collectAsStateWithLifecycle()

    LaunchedEffect(authState) {
        if (authState == null) {
            navigateOnSignOut(navController)
        }
    }

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
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(FARoute.Home) {
                        popUpTo(FARoute.Login) { inclusive = true }
                    }
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
                    navController.navigate(FARoute.Home) {
                        popUpTo(FARoute.SignUp) { inclusive = true }
                    }
                },
                viewModel = viewModel,
            )
        }
        composable<FARoute.Home> {
            HomeScreen(
                onAction = {
                    authRepository.logout()
                    navigateOnSignOut(navController)
                },
            )
        }
    }
}

private fun navigateOnSignOut(navController: NavController) {
    navController.navigate(FARoute.Login) {
        popUpTo(FARoute.Home) { inclusive = true }
    }
}

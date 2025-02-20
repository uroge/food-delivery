package com.urosmilosavljevic.foodapp.core.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginScreen
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpScreen
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpViewModel
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingScreenRoot
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FAAppNavigation(
    startDestination: FARoute,
    authRepository: AuthRepository,
) {
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

@Composable
fun HomeScreen(onAction: () -> Unit) {
    Text(
        text = "Home Screen",
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.onBackground,
    )
    Spacer(
        modifier =
            Modifier
                .height(16.dp),
    )
    FAButton(
        text = "Logout",
        onClick = {
            onAction()
        },
    )
}

private fun navigateOnSignOut(navController: NavController) {
    navController.navigate(FARoute.Login) {
        popUpTo(FARoute.Home) { inclusive = true }
    }
}

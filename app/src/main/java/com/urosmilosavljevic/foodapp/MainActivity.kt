package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.urosmilosavljevic.foodapp.authentication.presentation.LoginScreenRoot
import com.urosmilosavljevic.foodapp.core.navigation.FARoute
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingScreenRoot
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import android.os.Bundle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = FARoute.Root,
                ) {
                    composable<FARoute.Root> {
                        OnboardingScreenRoot(
                            viewModel = OnboardingViewModel(),
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
        }
    }
}

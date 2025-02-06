package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
                Column {
                    OnboardingScreenRoot(
                        viewModel = OnboardingViewModel(),
                    )
                }
            }
        }
    }
}

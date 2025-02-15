package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.urosmilosavljevic.foodapp.core.navigation.FAAppNavigation
import com.urosmilosavljevic.foodapp.core.navigation.FARoute
import com.urosmilosavljevic.foodapp.core.ui.components.SafeArea
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import org.koin.android.ext.android.inject
import android.os.Bundle

class MainActivity : ComponentActivity() {
    private val onboardingPreferences: OnboardingPreferences by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()

        val isOnboardingCompleted = onboardingPreferences.isOnboardingCompleted()
        val startDestination = if (isOnboardingCompleted) FARoute.Login else FARoute.Root

        setContent {
            FoodAppTheme {
                SafeArea {
                    FAAppNavigation(
                        startDestination,
                    )
                }
            }
        }
    }
}

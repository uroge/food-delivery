package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.core.navigation.FAAppNavigation
import com.urosmilosavljevic.foodapp.core.navigation.FARoute
import com.urosmilosavljevic.foodapp.core.ui.components.SafeArea
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import org.koin.android.ext.android.inject
import android.Manifest
import android.os.Build
import android.os.Bundle

class MainActivity : ComponentActivity() {
    private val onboardingPreferences: OnboardingPreferences by inject()
    private val authRepository: AuthRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.POST_NOTIFICATIONS,
                ),
                0,
            )
        }

        installSplashScreen()
        enableEdgeToEdge()

        val isOnboardingCompleted = onboardingPreferences.isOnboardingCompleted()
        val user = authRepository.getCurrentUser()

        val startDestination =
            when {
                !isOnboardingCompleted -> FARoute.Root
                user != null -> FARoute.Home
                else -> FARoute.Login
            }

        setContent {
            FoodAppTheme {
                SafeArea {
                    FAAppNavigation(
                        startDestination,
                        authRepository,
                    )
                }
            }
        }
    }
}

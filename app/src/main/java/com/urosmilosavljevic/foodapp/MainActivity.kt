package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.urosmilosavljevic.foodapp.core.navigation.FAAppNavigation
import com.urosmilosavljevic.foodapp.core.navigation.FARoute
import com.urosmilosavljevic.foodapp.core.ui.components.SafeArea
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import android.os.Bundle

class MainActivity : ComponentActivity() {
    private lateinit var onboardingPreferences: OnboardingPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()

        onboardingPreferences = OnboardingPreferences(context = this)

        lifecycleScope.launch {
            val isOnboardingCompleted = onboardingPreferences.isOnboardingCompleted.first()
            val startDestination = if (isOnboardingCompleted) FARoute.Login else FARoute.Root

            setContent {
                FoodAppTheme {
                    SafeArea { padding ->
                        Column(
                            modifier =
                                Modifier
                                    .fillMaxSize()
                                    .padding(padding),
                        ) {
                            FAAppNavigation(
                                startDestination,
                            )
                        }
                    }
                }
            }
        }
    }
}

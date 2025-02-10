package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.urosmilosavljevic.foodapp.core.navigation.FAAppNavigation
import com.urosmilosavljevic.foodapp.core.navigation.FARoute
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import android.os.Bundle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                FAAppNavigation(FARoute.Root)
            }
        }
    }
}

package com.urosmilosavljevic.foodapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import android.os.Bundle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        FAButton(
                            text = "Click me".uppercase(),
                            onClick = {},
                            modifier = Modifier.padding(innerPadding),
                        )
                        FAButton(
                            text = "Click me",
                            onClick = {},
                            modifier = Modifier.padding(innerPadding),
                            type = FAButtonTypes.TEXT,
                        )
                        FAButton(
                            text = "Click me",
                            onClick = {},
                            modifier = Modifier.padding(innerPadding),
                            type = FAButtonTypes.OUTLINED,
                        )
                    }
                }
            }
        }
    }
}

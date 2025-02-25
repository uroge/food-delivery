package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.services.LocationService
import android.content.Intent

@Composable
fun HomeScreen(onAction: () -> Unit) {
    val context = LocalContext.current
    Column {
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
        Spacer(
            modifier =
                Modifier
                    .height(16.dp),
        )
        FAButton(
            text = "Start Location Service",
            onClick = {
                val serviceIntent =
                    Intent(context, LocationService::class.java).apply {
                        action = LocationService.Actions.START.toString()
                    }
                context.startService(serviceIntent)
            },
        )
        Spacer(
            modifier =
                Modifier
                    .height(16.dp),
        )
        FAButton(
            text = "Stop Location Service",
            onClick = {
                val serviceIntent =
                    Intent(context, LocationService::class.java).apply {
                        action = LocationService.Actions.STOP.toString()
                    }
                context.startService(serviceIntent)
            },
        )
    }
}

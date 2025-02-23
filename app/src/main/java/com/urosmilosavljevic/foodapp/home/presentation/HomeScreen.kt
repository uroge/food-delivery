package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton

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

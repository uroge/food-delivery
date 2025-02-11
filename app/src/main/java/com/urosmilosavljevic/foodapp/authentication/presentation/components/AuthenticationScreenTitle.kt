package com.urosmilosavljevic.foodapp.authentication.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun AuthenticationScreenTitle(
    title: String,
    subtitle: String,
) {
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .padding(
                    top = 120.dp,
                    bottom = 70.dp,
                ),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun AuthenticationScreenTitlePreview() {
    FoodAppTheme {
        AuthenticationScreenTitle(
            title = "Log In",
            subtitle = "Please sign in to your existing account",
        )
    }
}

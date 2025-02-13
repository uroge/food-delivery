package com.urosmilosavljevic.foodapp.authentication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun AuthenticationScreenTitle(
    title: String,
    subtitle: String,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth().background(MaterialTheme.colorScheme.secondary)
                .height(300.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.auth_screen_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .fillMaxSize()
                    .alpha(0.7f),
        )
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
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
                modifier = Modifier.fillMaxWidth().padding(8.dp),
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

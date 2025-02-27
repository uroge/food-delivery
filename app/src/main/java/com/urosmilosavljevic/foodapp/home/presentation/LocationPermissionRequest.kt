package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun LocationPermissionRequest() {
    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.location_permission_icon),
                contentDescription = null,
            )
            Spacer(
                modifier = Modifier.height(56.dp),
            )
            FAButton(
                text = "Access location".uppercase(),
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                icon = painterResource(id = android.R.drawable.ic_menu_mylocation),
            )
            Spacer(
                modifier = Modifier.height(32.dp),
            )
            Text(
                "APP WILL ACCESS YOUR LOCATION ONLY WHILE USING THE APP",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun LocationPermissionRequestPreview() {
    FoodAppTheme {
        LocationPermissionRequest()
    }
}

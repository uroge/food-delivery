package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseUser
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import android.content.Context

@Composable
fun HomeScreenContent(
    context: Context,
    user: FirebaseUser?,
) {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
    ) {
        Column(modifier = Modifier.padding(24.dp, 42.dp, 24.dp, 0.dp)) {
            HomeScreenHeader()
            Spacer(modifier = Modifier.height(32.dp))
            user?.let {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Hey ${user.displayName}, ",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        "Good Afternoon",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))

            // SearchBar()
            // Categories
            // OpenRestaurants
        }
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() {
    FoodAppTheme {
        HomeScreenContent(
            context = LocalContext.current,
            user = null,
        )
    }
}

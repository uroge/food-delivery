package com.urosmilosavljevic.foodapp.authentication.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun AuthenticationScreenLayout(
    title: String,
    subtitle: String,
    primaryContent: @Composable () -> Unit,
    bottomContent: @Composable () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        AuthenticationScreenTitle(
            title = title,
            subtitle = subtitle,
        )
        Column(
            modifier =
                Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(
                        MaterialTheme.colorScheme.background,
                    ),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth(),
            ) {
                Box(modifier = Modifier.padding(24.dp)) {
                    primaryContent()
                }
            }
            bottomContent()
        }
    }
}

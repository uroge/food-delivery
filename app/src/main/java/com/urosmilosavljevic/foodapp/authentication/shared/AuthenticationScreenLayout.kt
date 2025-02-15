package com.urosmilosavljevic.foodapp.authentication.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.content.res.Configuration

@Composable
fun AuthenticationScreenLayout(
    title: String,
    subtitle: String,
    primaryContent: @Composable () -> Unit,
    bottomContent: (@Composable () -> Unit)? = null,
    onGoBack: (() -> Unit)? = null,
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val primaryContentMaxWidth = if (isLandscape) 500.dp else Dp.Unspecified

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary),
    ) {
        AuthenticationScreenTitle(
            title = title,
            subtitle = subtitle,
            onGoBack = onGoBack,
        )
        Column(
            modifier =
                Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(
                        MaterialTheme.colorScheme.background,
                    ).fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = if (isLandscape) 32.dp else 24.dp,
                            vertical = 24.dp,
                        ),
            ) {
                Box(modifier = Modifier.widthIn(max = primaryContentMaxWidth)) {
                    primaryContent()
                }
            }
            bottomContent?.let {
                Box(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(modifier = Modifier.widthIn(max = 400.dp)) {
                        it()
                    }
                }
            }
        }
    }
}

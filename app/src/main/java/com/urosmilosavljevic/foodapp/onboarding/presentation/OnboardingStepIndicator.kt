package com.urosmilosavljevic.foodapp.onboarding.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun OnboardingStepIndicator(
    currentPage: Int,
    totalPages: Int,
) {
    val activeColor = MaterialTheme.colorScheme.primary
    val inactiveColor = MaterialTheme.colorScheme.primaryContainer
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(totalPages) { index ->
            val isActive = index == currentPage
            val indicatorColor by animateColorAsState(
                targetValue = if (isActive) activeColor else inactiveColor,
                animationSpec = tween(durationMillis = 500),
                label = "stepColorAnimation",
            )

            Canvas(
                modifier =
                    Modifier
                        .size(12.dp),
            ) {
                drawCircle(color = indicatorColor)
            }
        }
    }
}

@Preview
@Composable
private fun OnboardingStepIndicatorPreview() {
    FoodAppTheme {
        OnboardingStepIndicator(
            currentPage = 0,
            totalPages = 3,
        )
    }
}

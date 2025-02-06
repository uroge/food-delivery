package com.urosmilosavljevic.foodapp.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun OnboardingScreenRoot(viewModel: OnboardingViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    OnboardingScreen(
        state = state,
        onNext = {
            viewModel.onAction(OnboardingAction.OnNext)
        },
        onSkip = {
            viewModel.onAction(OnboardingAction.OnSkip)
        },
    )
}

@Composable
private fun OnboardingScreen(
    state: OnboardingState,
    onNext: () -> Unit,
    onSkip: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (state.currentPage) {
            0 -> {
                Text("Page 1")
            }
            1 -> {
                Text("Page 2")
            }
            2 -> {
                Text("Page 3")
            }
        }
        FAButton(
            text = "Next".uppercase(),
            onClick = onNext,
            modifier = Modifier.fillMaxWidth(),
        )
        FAButton(
            text = "Skip",
            onClick = onSkip,
            type = FAButtonTypes.TEXT,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    val state = OnboardingState()
    FoodAppTheme {
        OnboardingScreen(
            state,
            onNext = {},
            onSkip = {},
        )
    }
}

package com.urosmilosavljevic.foodapp.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.urosmilosavljevic.foodapp.R
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
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                when (state.currentPage) {
                    0 -> {
                        OnboardingStepContent(
                            image = painterResource(id = R.drawable.onboarding_step_1),
                            title = "All your favourites",
                            text =
                                "Get all your loved foods in one once place,\n" +
                                    "you just place the order we do the rest",
                        )
                    }
                    1 -> {
                        OnboardingStepContent(
                            image = painterResource(id = R.drawable.onboarding_step_2),
                            title = "Order from chosen chef",
                            text =
                                "Get all your loved foods in one once place,\n" +
                                    "you just place the order we do the rest",
                        )
                    }
                    2 -> {
                        OnboardingStepContent(
                            image = painterResource(id = R.drawable.onboarding_step_3),
                            title = "Free delivery offers",
                            text =
                                "Get all your loved foods in one once place,\n" +
                                    "you just place the order we do the rest",
                        )
                    }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxWidth(),
            ) {
                OnboardingStepIndicator(
                    currentPage = state.currentPage,
                    totalPages = state.totalPages + 1,
                )
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                FAButton(
                    text = if (state.currentPage == state.totalPages) "Get started".uppercase() else "Next".uppercase(),
                    onClick = onNext,
                    modifier = Modifier.fillMaxWidth(),
                )
                FAButton(
                    text = "Skip",
                    onClick = onSkip,
                    type = FAButtonTypes.TEXT,
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
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

package com.urosmilosavljevic.foodapp.onboarding.presentation

sealed interface OnboardingAction {
    data object OnNext : OnboardingAction

    data object OnSkip : OnboardingAction
}

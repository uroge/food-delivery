package com.urosmilosavljevic.foodapp.onboarding.presentation

data class OnboardingState(
    var currentPage: Int = 0,
    val totalPages: Int = 2,
)

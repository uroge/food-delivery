package com.urosmilosavljevic.foodapp.onboarding.data

import android.content.Context

private const val ONBOARDING_PREFERENCES_NAME = "onboarding_preferences"
private const val ONBOARDING_PREFERENCES_KEY = "onboarding_completed"

class OnboardingPreferences(
    context: Context,
) {
    private val sharedPreferences = context.getSharedPreferences(ONBOARDING_PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun isOnboardingCompleted(): Boolean = sharedPreferences.getBoolean(ONBOARDING_PREFERENCES_KEY, false)

    fun setOnboardingCompleted() {
        sharedPreferences.edit().putBoolean(ONBOARDING_PREFERENCES_KEY, true).apply()
    }
}

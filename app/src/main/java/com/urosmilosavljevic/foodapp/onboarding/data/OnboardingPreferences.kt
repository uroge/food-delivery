package com.urosmilosavljevic.foodapp.onboarding.data

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import android.content.Context

private const val ONBOARDING_PREFERENCES_NAME = "onboarding_preferences"
private const val ONBOARDING_PREFERENCES_KEY = "onboarding_completed"

private val Context.dataStore by preferencesDataStore(name = ONBOARDING_PREFERENCES_NAME)

class OnboardingPreferences(
    private val context: Context,
) {
    private val onboardingCompletedKey = booleanPreferencesKey(ONBOARDING_PREFERENCES_KEY)

    val isOnboardingCompleted: Flow<Boolean> =
        context.dataStore.data
            .map { preferences -> preferences[onboardingCompletedKey] ?: false }

    suspend fun setOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[onboardingCompletedKey] = completed
        }
    }
}

package com.urosmilosavljevic.foodapp.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val preferences: OnboardingPreferences,
) : ViewModel() {
    private val _state = MutableStateFlow(OnboardingState())
    val state: StateFlow<OnboardingState> = _state

    fun onAction(
        action: OnboardingAction,
        onOnboardingFinished: (() -> Unit)? = null,
    ) {
        when (action) {
            is OnboardingAction.OnNext -> {
                if (_state.value.currentPage == _state.value.totalPages) {
                    handleOnboardingFinish()
                    if (onOnboardingFinished != null) {
                        onOnboardingFinished()
                    }
                } else {
                    handleNextPage()
                }
            }
            is OnboardingAction.OnSkip -> {
                handleOnboardingFinish()
                if (onOnboardingFinished != null) {
                    onOnboardingFinished()
                }
            }
        }
    }

    private fun handleOnboardingFinish() {
        viewModelScope.launch {
            preferences.setOnboardingCompleted(true)
        }
    }

    private fun handleNextPage() {
        _state.value = _state.value.copy(currentPage = _state.value.currentPage + 1)
    }
}

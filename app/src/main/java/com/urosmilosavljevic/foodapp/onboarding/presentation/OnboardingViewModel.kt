package com.urosmilosavljevic.foodapp.onboarding.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OnboardingViewModel : ViewModel() {
    private val _state = MutableStateFlow(OnboardingState())
    val state: StateFlow<OnboardingState> = _state

    fun onAction(action: OnboardingAction) {
        when (action) {
            is OnboardingAction.OnNext -> {
                handleNextPage()
            }
            is OnboardingAction.OnSkip -> {
                handleSkip()
            }
        }
    }

    private fun handleNextPage() {
        if (state.value.currentPage == state.value.totalPages) {
            println("FINISHED")
            return
        }

        _state.value = _state.value.copy(currentPage = _state.value.currentPage + 1)
    }

    private fun handleSkip() {
        // TODO: Implement
    }
}

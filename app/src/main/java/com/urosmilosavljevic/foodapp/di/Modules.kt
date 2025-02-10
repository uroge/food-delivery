package com.urosmilosavljevic.foodapp.di

import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        single { OnboardingPreferences(context = get()) }
        viewModel { OnboardingViewModel(preferences = get()) }
    }

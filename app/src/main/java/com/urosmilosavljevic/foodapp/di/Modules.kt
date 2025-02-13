package com.urosmilosavljevic.foodapp.di

import com.urosmilosavljevic.foodapp.authentication.login.domain.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.login.domain.ValidatePassword
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        single { OnboardingPreferences(context = get()) }
        viewModel { OnboardingViewModel(preferences = get()) }
        single { ValidateEmail() }
        single { ValidatePassword() }
        viewModel { LoginViewModel(validateEmail = get(), validatePassword = get()) }
    }

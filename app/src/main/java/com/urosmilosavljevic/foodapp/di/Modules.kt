package com.urosmilosavljevic.foodapp.di

import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.authentication.shared.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.shared.ValidatePassword
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateConfirmPassword
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateName
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpViewModel
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
        single { ValidateName() }
        single { ValidateConfirmPassword() }
        viewModel { LoginViewModel(validateEmail = get(), validatePassword = get()) }
        viewModel {
            SignUpViewModel(
                validateName = get(),
                validateEmail = get(),
                validatePassword = get(),
                validateConfirmPassword = get(),
            )
        }
    }

package com.urosmilosavljevic.foodapp.di

import com.google.firebase.auth.FirebaseAuth
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidateEmail
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidatePassword
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateConfirmPassword
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateName
import com.urosmilosavljevic.foodapp.authentication.signup.presentation.SignUpViewModel
import com.urosmilosavljevic.foodapp.onboarding.data.OnboardingPreferences
import com.urosmilosavljevic.foodapp.onboarding.presentation.OnboardingViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule =
    module {
        single { OnboardingPreferences(context = androidContext()) }
        viewModelOf(::OnboardingViewModel)

        single { FirebaseAuth.getInstance() }
        single { AuthRepository(auth = get()) }

        single { ValidateEmail() }
        single { ValidatePassword() }
        single { ValidateName() }
        single { ValidateConfirmPassword() }
        viewModelOf(::LoginViewModel)
        viewModelOf(::SignUpViewModel)
    }

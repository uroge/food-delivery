package com.urosmilosavljevic.foodapp.di

import com.google.firebase.auth.FirebaseAuth
import com.urosmilosavljevic.foodapp.authentication.login.presentation.LoginViewModel
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidateEmailUseCase
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidatePasswordUseCase
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateConfirmPasswordUseCase
import com.urosmilosavljevic.foodapp.authentication.signup.domain.ValidateNameUseCase
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

        single { ValidateEmailUseCase() }
        single { ValidatePasswordUseCase() }
        single { ValidateNameUseCase() }
        single { ValidateConfirmPasswordUseCase() }
        viewModelOf(::LoginViewModel)
        viewModelOf(::SignUpViewModel)
    }

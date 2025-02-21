package com.urosmilosavljevic.foodapp.authentication.signup.domain

import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidatePasswordUseCase
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidationResult

class ValidateConfirmPasswordUseCase : ValidatePasswordUseCase() {
    fun execute(
        confirmedPassword: String,
        password: String,
    ): ValidationResult {
        val result = super.execute(confirmedPassword)

        if (result.successful) {
            if (confirmedPassword != password) {
                return ValidationResult(
                    successful = false,
                    errorMessage = "Passwords don't match",
                )
            }

            return result
        } else {
            return result
        }
    }
}

package com.urosmilosavljevic.foodapp.authentication.signup.domain

import com.urosmilosavljevic.foodapp.R
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
                    errorMessageId = R.string.input_confirm_password_error,
                )
            }

            return result
        } else {
            return result
        }
    }
}

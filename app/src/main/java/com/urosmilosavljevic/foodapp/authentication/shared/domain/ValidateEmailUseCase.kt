package com.urosmilosavljevic.foodapp.authentication.shared.domain

import com.urosmilosavljevic.foodapp.R
import android.util.Patterns

class ValidateEmailUseCase {
    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessageId = R.string.input_email_blank_error,
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessageId = R.string.input_email_invalid_error,
            )
        }
        return ValidationResult(
            successful = true,
        )
    }
}

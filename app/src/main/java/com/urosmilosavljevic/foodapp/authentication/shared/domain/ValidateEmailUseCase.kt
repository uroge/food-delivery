package com.urosmilosavljevic.foodapp.authentication.shared.domain

import android.util.Patterns

class ValidateEmailUseCase {
    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The email can't be blank",
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "That's not a valid email",
            )
        }
        return ValidationResult(
            successful = true,
        )
    }
}

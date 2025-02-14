package com.urosmilosavljevic.foodapp.authentication.signup.domain

import com.urosmilosavljevic.foodapp.authentication.shared.ValidationResult

class ValidateName {
    fun execute(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "Name cannot be empty",
            )
        }
        return ValidationResult(
            successful = true,
        )
    }
}

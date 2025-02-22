package com.urosmilosavljevic.foodapp.authentication.signup.domain

import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.authentication.shared.domain.ValidationResult

class ValidateNameUseCase {
    fun execute(name: String): ValidationResult {
        if (name.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessageId = R.string.input_name_blank_error,
            )
        }
        return ValidationResult(
            successful = true,
        )
    }
}

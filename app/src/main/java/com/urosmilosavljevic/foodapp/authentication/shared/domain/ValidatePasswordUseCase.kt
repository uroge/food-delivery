package com.urosmilosavljevic.foodapp.authentication.shared.domain

import com.urosmilosavljevic.foodapp.R

open class ValidatePasswordUseCase {
    open fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessageId = R.string.input_password_length_error,
            )
        }
        val containsLettersAndDigits =
            password.any { it.isDigit() } &&
                password.any { it.isLetter() }
        if (!containsLettersAndDigits) {
            return ValidationResult(
                successful = false,
                errorMessageId = R.string.input_password_format_error,
            )
        }
        return ValidationResult(
            successful = true,
        )
    }
}

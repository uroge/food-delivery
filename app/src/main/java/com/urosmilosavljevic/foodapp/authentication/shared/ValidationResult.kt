package com.urosmilosavljevic.foodapp.authentication.shared

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null,
)

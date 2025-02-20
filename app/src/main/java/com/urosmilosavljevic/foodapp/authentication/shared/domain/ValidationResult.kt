package com.urosmilosavljevic.foodapp.authentication.shared.domain

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null,
)

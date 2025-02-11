package com.urosmilosavljevic.foodapp.authentication.domain

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null,
)

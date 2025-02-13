package com.urosmilosavljevic.foodapp.authentication.login.domain

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null,
)

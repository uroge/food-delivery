package com.urosmilosavljevic.foodapp.core.navigation

import kotlinx.serialization.Serializable

sealed interface FARoute {
    @Serializable
    data object Root : FARoute

    @Serializable
    data object Login : FARoute

    @Serializable
    data object Home : FARoute
}

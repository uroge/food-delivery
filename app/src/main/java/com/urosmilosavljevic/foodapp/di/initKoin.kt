@file:Suppress("ktlint:standard:filename")

package com.urosmilosavljevic.foodapp.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        appModule
    }
}

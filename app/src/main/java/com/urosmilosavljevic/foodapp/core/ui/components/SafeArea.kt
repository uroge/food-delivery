package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp

@Composable
fun SafeArea(content: @Composable (PaddingValues) -> Unit) {
    val layoutDirection = LocalLayoutDirection.current
    val systemBarsInsets = WindowInsets.statusBars.union(WindowInsets.navigationBars)

    val startPadding: Dp = systemBarsInsets.asPaddingValues().calculateStartPadding(layoutDirection)
    val topPadding: Dp = systemBarsInsets.asPaddingValues().calculateTopPadding()
    val endPadding: Dp = systemBarsInsets.asPaddingValues().calculateEndPadding(layoutDirection)
    val bottomPadding: Dp = systemBarsInsets.asPaddingValues().calculateBottomPadding()

    val safeAreaPadding =
        PaddingValues(
            start = startPadding,
            top = topPadding,
            end = endPadding,
            bottom = bottomPadding,
        )

    content(safeAreaPadding)
}

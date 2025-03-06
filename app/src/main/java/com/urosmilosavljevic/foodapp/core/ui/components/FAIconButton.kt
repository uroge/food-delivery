package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun FAIconButton(
    onClick: () -> Unit,
    icon: Painter,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    size: Int = 45,
    iconSize: Int = 16,
    iconColor: Color = MaterialTheme.colorScheme.onSurface,
    contentDescription: String,
) {
    IconButton(
        modifier =
            Modifier
                .clip(CircleShape)
                .background(backgroundColor)
                .size(size.dp),
        onClick = {
            onClick()
        },
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(size.dp),
        ) {
            Icon(
                painter = icon,
                contentDescription = contentDescription,
                modifier =
                    Modifier
                        .size(iconSize.dp),
                tint = iconColor,
            )
        }
    }
}

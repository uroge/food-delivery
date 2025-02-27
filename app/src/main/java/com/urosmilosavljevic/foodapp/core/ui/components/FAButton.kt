package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

enum class FAButtonTypes {
    FILLED,
    OUTLINED,
    TEXT,
}

enum class FAButtonDensity {
    HIGH,
    MEDIUM,
    LOW,
}

@Composable
fun FAButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: FAButtonTypes = FAButtonTypes.FILLED,
    density: FAButtonDensity = FAButtonDensity.MEDIUM,
    disabled: Boolean = false,
    isLoading: Boolean = false,
    icon: Painter? = null,
) {
    val paddingVertical =
        when (density) {
            FAButtonDensity.HIGH -> 16.dp
            FAButtonDensity.MEDIUM -> 10.dp
            FAButtonDensity.LOW -> 4.dp
        }

    val shouldDisable =
        remember {
            derivedStateOf { disabled || isLoading }
        }

    val buttonContent: @Composable () -> Unit = {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            FAButtonText(text = text, paddingVertical = paddingVertical)
            if (icon != null) {
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = icon,
                    contentDescription = "Location Icon",
                    modifier =
                        Modifier
                            .size(24.dp)
                            .background(Color.White.copy(alpha = 0.2f), shape = CircleShape)
                            .padding(4.dp),
                )
            }
            if (isLoading) {
                Spacer(modifier = Modifier.width(8.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
    }

    when (type) {
        FAButtonTypes.FILLED ->
            FilledTonalButton(
                onClick = onClick,
                modifier = modifier,
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                shape = MaterialTheme.shapes.small,
                enabled = !shouldDisable.value,
            ) {
                buttonContent()
            }
        FAButtonTypes.OUTLINED ->
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                shape = MaterialTheme.shapes.small,
                enabled = !shouldDisable.value,
            ) {
                buttonContent()
            }
        FAButtonTypes.TEXT ->
            TextButton(
                onClick = onClick,
                modifier = modifier,
                shape = MaterialTheme.shapes.small,
                enabled = !shouldDisable.value,
            ) {
                buttonContent()
            }
    }
}

@Composable
private fun FAButtonText(
    text: String,
    paddingVertical: Dp,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleSmall,
        modifier =
            Modifier.padding(
                vertical = paddingVertical,
            ),
    )
}

@Preview
@Composable
private fun FAButtonPreview() {
    FoodAppTheme {
        FAButton(
            text = "Click me".uppercase(),
            onClick = {},
            type = FAButtonTypes.FILLED,
            isLoading = true,
            icon = painterResource(id = android.R.drawable.ic_menu_mylocation),
        )
    }
}

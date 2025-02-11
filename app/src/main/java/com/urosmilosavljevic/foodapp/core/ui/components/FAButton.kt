package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
) {
    val paddingVertical =
        when (density) {
            FAButtonDensity.HIGH -> 16.dp
            FAButtonDensity.MEDIUM -> 10.dp
            FAButtonDensity.LOW -> 4.dp
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
            ) {
                FAButtonText(text = text, paddingVertical = paddingVertical)
            }
        FAButtonTypes.OUTLINED ->
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                shape = MaterialTheme.shapes.small,
            ) {
                FAButtonText(text = text, paddingVertical = paddingVertical)
            }
        FAButtonTypes.TEXT ->
            TextButton(
                onClick = onClick,
                modifier = modifier,
                shape = MaterialTheme.shapes.small,
            ) {
                FAButtonText(text = text, paddingVertical = paddingVertical)
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
        )
    }
}

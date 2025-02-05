package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class FAButtonTypes {
    FILLED,
    OUTLINED,
    TEXT,
}

@Composable
fun FAButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: FAButtonTypes = FAButtonTypes.FILLED,
) {
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
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        FAButtonTypes.OUTLINED ->
            OutlinedButton(
                onClick = onClick,
                modifier = modifier,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                shape = MaterialTheme.shapes.small,
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        FAButtonTypes.TEXT ->
            TextButton(
                onClick = onClick,
                modifier = modifier,
            ) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.titleSmall,
                )
            }
    }
}

@Preview
@Composable
private fun FAButtonPreview() {
    FAButton(text = "Click me".uppercase(), onClick = {}, type = FAButtonTypes.OUTLINED)
}

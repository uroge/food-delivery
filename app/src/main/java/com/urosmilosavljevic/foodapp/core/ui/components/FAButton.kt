package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FAButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
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
            text = text.uppercase(),
            style = MaterialTheme.typography.titleSmall,

        )
    }
}

@Preview
@Composable
private fun FAButtonPreview() {
    FAButton(text = "Click me", onClick = {})
}

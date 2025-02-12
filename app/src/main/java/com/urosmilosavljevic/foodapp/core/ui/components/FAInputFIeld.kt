package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun FAInputField(
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholder: String,
    value: String = "",
    onChange: (String) -> Unit = { },
    label: String? = null,
    hasError: Boolean = false,
    errorMessage: String? = null,
    maxLength: Int? = null,
    isClearable: Boolean = false,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    val isPasswordInput = keyboardOptions.keyboardType == KeyboardType.Password
    var passwordVisible by remember { mutableStateOf(false) }

    Column {
        if (label != null) {
            Text(
                label.uppercase(),
                style = MaterialTheme.typography.bodySmall,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        TextField(
            value = value,
            onValueChange = {
                if (maxLength == null || it.length <= maxLength) {
                    onChange(it)
                }
            },
            modifier =
                modifier.then(
                    if (hasError) {
                        Modifier.border(1.2.dp, MaterialTheme.colorScheme.error, MaterialTheme.shapes.extraSmall)
                    } else {
                        Modifier
                    },
                ),
            placeholder = { Text(text = placeholder) },
            colors =
                TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.tertiary,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedTextColor = MaterialTheme.colorScheme.onSurface,
                    unfocusedTextColor = MaterialTheme.colorScheme.onTertiary,
                    unfocusedPlaceholderColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedPlaceholderColor = MaterialTheme.colorScheme.surfaceVariant,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    errorPlaceholderColor = MaterialTheme.colorScheme.error,
                    errorContainerColor = MaterialTheme.colorScheme.surface,
                ),
            keyboardOptions =
                KeyboardOptions(
                    imeAction = keyboardOptions.imeAction,
                    keyboardType =
                        if (passwordVisible) {
                            KeyboardType.Text
                        } else {
                            keyboardOptions.keyboardType
                        },
                ),
            shape = MaterialTheme.shapes.extraSmall,
            isError = hasError,
            trailingIcon = {
                if (isPasswordInput) {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector =
                                if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }
                } else if (isClearable && value.isNotEmpty()) {
                    IconButton(onClick = { onChange("") }) {
                        Icon(
                            imageVector = Icons.Filled.Clear,
                            contentDescription = "Clear input",
                            tint = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    }
                }
            },
            visualTransformation =
                if (isPasswordInput && !passwordVisible) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
            keyboardActions = keyboardActions,
        )
        if (hasError && errorMessage != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
            )
        }
    }
}

@Preview
@Composable
private fun FAInputFieldPreview() {
    FoodAppTheme {
        Column(
            modifier =
                Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            FAInputField(
                placeholder = "example@gmail.com",
                value = "Bakalar",
                label = "Email",
                isClearable = true,
            )
            Spacer(modifier = Modifier.height(16.dp))
            FAInputField(
                placeholder = "Password",
                label = "Password",
                hasError = true,
                errorMessage = "Password is required",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
        }
    }
}

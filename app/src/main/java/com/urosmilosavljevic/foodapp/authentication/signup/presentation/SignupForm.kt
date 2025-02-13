package com.urosmilosavljevic.foodapp.authentication.signup.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAInputField
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun SignupForm() {
    val focusManager = LocalFocusManager.current

    Column {
        FAInputField(
            placeholder = "John Doe",
            value = "",
            label = "Name",
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
            },
            hasError = false,
            errorMessage = "",
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                ),
            keyboardActions =
                KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        FAInputField(
            placeholder = "example@gmail.com",
            value = "",
            label = "Email",
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
            onChange = {
            },
            hasError = false,
            errorMessage = "",
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                ),
            keyboardActions =
                KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        FAInputField(
            placeholder = "Password",
            label = "Password",
            value = "",
            modifier = Modifier.fillMaxWidth(),
            onChange = {
            },
            hasError = false,
            errorMessage = "",
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next,
                ),
            keyboardActions =
                KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                ),
        )
        Spacer(modifier = Modifier.height(20.dp))
        FAInputField(
            placeholder = "Re-Type Password",
            label = "Re-Type password",
            value = "",
            keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                ),
            modifier = Modifier.fillMaxWidth(),
            onChange = {
            },
            hasError = false,
            errorMessage = "",
            keyboardActions =
                KeyboardActions(
                    onDone = {
                    },
                ),
        )
        Spacer(modifier = Modifier.height(32.dp))
        FAButton(
            text = "Sign Up".uppercase(),
            onClick = {
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun PreviewSignupForm() {
    FoodAppTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            SignupForm()
        }
    }
}

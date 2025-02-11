package com.urosmilosavljevic.foodapp.authentication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.components.FACheckbox
import com.urosmilosavljevic.foodapp.core.ui.components.FAInputField
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun LoginForm() {
    Column(
        modifier =
            Modifier
                .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        FAInputField(
            placeholder = "example@gmail.com",
            value = "Bakalar",
            label = "Email",
            isClearable = true,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        FAInputField(
            placeholder = "Password",
            label = "Password",
            type = KeyboardType.Password,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            FACheckbox(
                checked = false,
                onCheckedChange = {},
                label = "Remember me",
            )
            FAButton(
                text = "Forgot Password",
                onClick = {},
                type = FAButtonTypes.TEXT,
            )
        }
    }
}

@Preview
@Composable
private fun LoginFormPreview() {
    FoodAppTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
        ) {
            LoginForm()
        }
    }
}

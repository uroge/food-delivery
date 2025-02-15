package com.urosmilosavljevic.foodapp.authentication.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonDensity
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun SignUpOptions(onSignupClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Don't have an account?", color = MaterialTheme.colorScheme.onBackground)
            Spacer(modifier = Modifier.width(4.dp))
            FAButton(
                text = "Sign Up".uppercase(),
                onClick = {
                    onSignupClick()
                },
                density = FAButtonDensity.LOW,
                type = FAButtonTypes.TEXT,
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text("Or", color = MaterialTheme.colorScheme.onBackground)
        Spacer(modifier = Modifier.width(8.dp))
        SocialLoginButtons()
    }
}

@Preview
@Composable
private fun SignUpOptionsPreview() {
    FoodAppTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
        ) {
            SignUpOptions()
        }
    }
}

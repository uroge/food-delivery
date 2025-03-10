package com.urosmilosavljevic.foodapp.home.presentation

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import android.Manifest

@Composable
fun LocationPermissionRequest() {
    val permissions =
        arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )

    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
        ) { result ->
            if (result.all { it.value }) {
                println("PERMISSIONS GRANTED")
            } else {
                println("PERMISSIONS NOT GRANTED")
            }
        }

    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.location_permission_icon),
                contentDescription = stringResource(R.string.location_permission_icon_description),
            )
            Spacer(
                modifier = Modifier.height(56.dp),
            )
            FAButton(
                text = stringResource(R.string.access_location_button).uppercase(),
                onClick = {
                    launcher.launch(permissions)
                },
                modifier = Modifier.fillMaxWidth(),
                icon = {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_mylocation),
                        contentDescription = stringResource(R.string.location_icon_description),
                        modifier =
                            Modifier
                                .size(24.dp)
                                .background(Color.White.copy(alpha = 0.2f), shape = CircleShape)
                                .padding(4.dp),
                    )
                },
            )
            Spacer(
                modifier = Modifier.height(32.dp),
            )
            Text(
                text = stringResource(R.string.location_permission_message),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun LocationPermissionRequestPreview() {
    FoodAppTheme {
        LocationPermissionRequest()
    }
}

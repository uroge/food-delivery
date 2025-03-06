package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import com.urosmilosavljevic.foodapp.authentication.shared.data.AuthRepository
import android.Manifest
import android.content.Context
import android.content.pm.PackageManager

fun arePermissionsGranted(context: Context): Boolean {
    val permissions =
        arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )

    return permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }
}

@Composable
fun HomeScreen(
    onAction: () -> Unit,
    authRepository: AuthRepository,
) {
    val context = LocalContext.current

    when {
        !arePermissionsGranted(context) -> {
            LocationPermissionRequest()
        }
        else -> {
            HomeScreenContent(context, user = authRepository.getCurrentUser())
        }
    }
}
//
// @Composable
// fun HomeScreenContent(
//    context: Context,
//    onAction: () -> Unit,
// ) {
//    Column {
//        Text(
//            text = "Home Screen",
//            style = MaterialTheme.typography.headlineLarge,
//            color = MaterialTheme.colorScheme.onBackground,
//        )
//        Spacer(
//            modifier =
//                Modifier
//                    .height(16.dp),
//        )
//        FAButton(
//            text = "Logout",
//            onClick = {
//                onAction()
//            },
//        )
//        Spacer(
//            modifier =
//                Modifier
//                    .height(16.dp),
//        )
//        FAButton(
//            text = "Start Location Service",
//            onClick = {
//                val serviceIntent =
//                    Intent(context, LocationService::class.java).apply {
//                        action = LocationService.Actions.START.toString()
//                    }
//                context.startService(serviceIntent)
//            },
//        )
//        Spacer(
//            modifier =
//                Modifier
//                    .height(16.dp),
//        )
//        FAButton(
//            text = "Stop Location Service",
//            onClick = {
//                val serviceIntent =
//                    Intent(context, LocationService::class.java).apply {
//                        action = LocationService.Actions.STOP.toString()
//                    }
//                context.startService(serviceIntent)
//            },
//        )
//    }
// }

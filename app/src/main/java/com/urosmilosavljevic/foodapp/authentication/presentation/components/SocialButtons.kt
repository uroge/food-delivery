package com.urosmilosavljevic.foodapp.authentication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.R

@Composable
fun SocialLoginButtons() {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        SocialButton(R.drawable.facebook_icon, Color(0xFF395998))
        SocialButton(R.drawable.twitter_icon, Color(0xFF169CE8))
        SocialButton(R.drawable.apple_icon, Color(0xFF1B1F2F))
    }
}

@Composable
fun SocialButton(
    iconRes: Int,
    backgroundColor: Color,
) {
    Box(
        modifier =
            Modifier
                .size(62.dp)
                .clip(CircleShape)
                .background(backgroundColor)
                .clickable {
                    // TODO: Implement social login
                },
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            colorFilter = ColorFilter.tint(Color.White),
        )
    }
}

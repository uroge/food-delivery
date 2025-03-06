package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.core.ui.components.FAIconButton
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun HomeScreenHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FAIconButton(
            onClick = {},
            icon = painterResource(id = R.drawable.menu_icon),
            contentDescription = "Menu icon",
            backgroundColor = MaterialTheme.colorScheme.surface,
            iconColor = MaterialTheme.colorScheme.secondary,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                "Deliver TO".uppercase(),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp,
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                "Your Location",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        CartButton()
    }
}

@Composable
private fun CartButton(onCartClicked: () -> Unit = {}) {
    FAIconButton(
        onClick = {
            onCartClicked()
        },
        icon = painterResource(id = R.drawable.cart_icon),
        contentDescription = "Menu icon",
        backgroundColor = MaterialTheme.colorScheme.secondary,
        iconColor = MaterialTheme.colorScheme.background,
        iconSize = 20,
    )
}

@Preview
@Composable
private fun HomeScreenHeaderPreview() {
    FoodAppTheme {
        HomeScreenHeader()
    }
}

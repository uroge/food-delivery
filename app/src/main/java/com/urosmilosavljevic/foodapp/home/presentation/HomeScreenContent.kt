package com.urosmilosavljevic.foodapp.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseUser
import com.urosmilosavljevic.foodapp.R
import com.urosmilosavljevic.foodapp.core.ui.components.FAButton
import com.urosmilosavljevic.foodapp.core.ui.components.FAButtonTypes
import com.urosmilosavljevic.foodapp.core.ui.components.FAInputField
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme
import java.util.Calendar
import android.content.Context

@Composable
fun HomeScreenContent(
    context: Context,
    user: FirebaseUser?,
) {
    val currentHour = remember { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) }

    val greetingText =
        when {
            currentHour < 12 -> stringResource(R.string.home_screen_good_morning)
            currentHour < 18 -> stringResource(R.string.home_screen_good_afternoon)
            else -> stringResource(R.string.home_screen_good_evening)
        }
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
    ) {
        Column(modifier = Modifier.padding(24.dp, 42.dp, 24.dp, 0.dp)) {
            HomeScreenHeader()
            Spacer(modifier = Modifier.height(32.dp))
            user?.let {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(R.string.home_screen_greeting, user.displayName ?: ""),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        text = greetingText,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            FAInputField(
                label = stringResource(R.string.input_search_label),
                value = "",
                onChange = {},
                placeholder = stringResource(R.string.input_search_placeholder),
                isClearable = true,
                singleLine = true,
                leadingIcon =
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = stringResource(R.string.search_icon_description),
                        )
                    },
            )
            Spacer(modifier = Modifier.height(32.dp))
            HomeScreenSectionTitle(
                title = stringResource(R.string.home_all_categories),
                onAction = {},
            )
            HomeScreenSectionTitle(
                title = stringResource(R.string.home_open_restaurants),
                onAction = {},
            )
        }
    }
}

@Composable
private fun HomeScreenSectionTitle(
    title: String,
    onAction: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )
        FAButton(
            type = FAButtonTypes.TEXT,
            onClick = onAction,
            text = "See All",
            icon = {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = null,
                    modifier =
                        Modifier
                            .size(24.dp)
                            .background(Color.White.copy(alpha = 0.2f))
                            .padding(4.dp),
                )
            },
        )
    }
}

@Preview
@Composable
fun HomeScreenContentPreview() {
    FoodAppTheme {
        HomeScreenContent(
            context = LocalContext.current,
            user = null,
        )
    }
}

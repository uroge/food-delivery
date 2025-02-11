package com.urosmilosavljevic.foodapp.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.urosmilosavljevic.foodapp.core.ui.theme.FoodAppTheme

@Composable
fun FACheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String? = null,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier =
                Modifier
                    .size(20.dp)
                    .then(
                        if (checked) {
                            Modifier.clip(RoundedCornerShape(6.dp))
                        } else {
                            Modifier.border(2.dp, MaterialTheme.colorScheme.tertiary, RoundedCornerShape(5.dp))
                        },
                    )
                    .background(if (checked) MaterialTheme.colorScheme.primary else Color.Transparent)
                   .clickable { onCheckedChange(!checked) },
            contentAlignment = Alignment.Center,
        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "$label checked",
                    tint = MaterialTheme.colorScheme.onPrimary,
                )
            }
        }
        if (label != null) {
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Composable
@Preview
fun CustomCheckboxPreview() {
    var isChecked by remember { mutableStateOf(false) }

    FoodAppTheme {
        Row(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            FACheckbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                label = "Remember me",
            )
        }
    }
}

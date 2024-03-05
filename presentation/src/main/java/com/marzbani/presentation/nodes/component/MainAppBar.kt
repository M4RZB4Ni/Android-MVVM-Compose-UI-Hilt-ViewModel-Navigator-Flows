package com.marzbani.presentation.nodes.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marzbani.presentation.R

/**
 * Composable function for the main app bar, used in the UI.
 *
 * @param modifier Optional modifier for customization.
 * @param onEditClick Click listener for the edit icon.
 */
@Composable
fun MainAppBar(
    modifier: Modifier = Modifier, // Optional modifier for customization
    onEditClick: () -> Unit // Click listener for the edit icon
) {
    // Card component to create a visual container with elevation and color.
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        )
    ) {
        // Row to arrange child components horizontally.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Nested Row for the app name and edit icon.
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Text component to display the app name with a specific style.
                Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.headlineSmall)

                // Icon component for the edit action.
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(id = R.string.edit),
                    tint = Color.White,
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .clickable { onEditClick() } // Clickable region with the provided listener.
                )
            }
        }
    }
}

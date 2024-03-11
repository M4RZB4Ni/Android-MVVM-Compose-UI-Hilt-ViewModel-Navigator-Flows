package com.marzbani.presentation.details.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marzbani.presentation.R

/**
 * Composable function representing the AppBar in the details screen.
 *
 * @param modifier Custom modifier for additional styling if needed.
 * @param onBackClick Callback for handling back button click.
 * @param onEditClick Callback for handling edit button click.
 * @param onShareClick Callback for handling share button click.
 */
@Composable
fun DetailsAppBar(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    onShareClick: () -> Unit
) {
    // Card for styling and elevation
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
    ) {
        // Row for horizontal arrangement of back button and icons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Back button with click handling
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(id = R.string.back),
                tint = Color.White,
                modifier = Modifier
                    .size(34.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .clickable { onBackClick() }
            )

            // Row for edit and share icons with spacing
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Edit icon with click handling
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(id = R.string.edit),
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .clickable { onEditClick() }
                )

                // Share icon with click handling
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(id = R.string.share),
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .clickable { onShareClick() }
                )
            }
        }
    }
}

package com.marzbani.presentation.nodes.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marzbani.presentation.R

/**
 * TreeNodeEditActions is a Composable function responsible for rendering edit actions (remove and move) for a tree node.
 * It provides IconButton components for removing and moving the tree node.
 *
 * @param onRemoveClick A callback function triggered when the remove button is clicked.
 * @param onMoveClick A callback function triggered when the move button is clicked.
 */
@Composable
fun TreeNodeEditActions(
    onRemoveClick: () -> Unit,
    onMoveClick: () -> Unit
) {
    // Row layout to organize the IconButton components horizontally with space between them
    Row(
        modifier = Modifier
            .fillMaxWidth() // Occupy the entire available width
            .padding(top = 8.dp), // Add top padding for spacing
        horizontalArrangement = Arrangement.SpaceBetween // Space evenly between the IconButton components
    ) {
        // IconButton for removing the tree node
        IconButton(onClick = onRemoveClick) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.remove), // Content description for accessibility
                tint = MaterialTheme.colorScheme.error // Use error color for visual indication
            )
        }

        // IconButton for moving the tree node
        IconButton(onClick = onMoveClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = stringResource(id = R.string.move), // Content description for accessibility
                tint = MaterialTheme.colorScheme.secondary // Use secondary color for visual indication
            )
        }
    }
}

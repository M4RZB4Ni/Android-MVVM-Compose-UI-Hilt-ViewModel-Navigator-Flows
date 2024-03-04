package com.marzbani.presentation.nodes.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marzbani.domain.entity.TreeNodeEntity


/**
 * TreeNodeContent is a Composable function responsible for rendering the content of a tree node in a Row layout.
 * It takes a TreeNodeEntity and a callback function onItemClick as parameters.
 *
 * @param treeNode The TreeNodeEntity representing the data to be displayed.
 * @param onItemClick A callback function triggered when the tree node is clicked.
 */
@Composable
fun TreeNodeContent(treeNode: TreeNodeEntity, onItemClick: (TreeNodeEntity) -> Unit) {
    // Row layout to organize the components horizontally
    Row(
        modifier = Modifier
            .fillMaxWidth() // Occupy the entire available width
            .padding(bottom = 8.dp), // Add bottom padding for spacing
        verticalAlignment = Alignment.CenterVertically // Center the components vertically
    ) {
        // Icon component displaying the default AccountBox icon
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null, // No content description for icon
        )
        // Spacer to add space between the icon and text
        Spacer(modifier = Modifier.width(8.dp))
        // Text component displaying the label of the tree node
        Text(text = treeNode.label)
    }
}

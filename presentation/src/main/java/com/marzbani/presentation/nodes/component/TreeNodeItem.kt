package com.marzbani.presentation.nodes.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.marzbani.domain.entity.TreeNodeEntity

/*
 * TreeNodeItem is a Composable function responsible for rendering a tree node as a Card in the UI.
 * It displays the content of the node and, if available, recursively renders its children using LazyColumn.
 * In edit mode, it also shows edit actions for removing and moving the node.
 *
 * @param modifier The modifier for styling and positioning the TreeNodeItem.
 * @param treeNode The TreeNodeEntity representing the data to be displayed.
 * @param onItemClick A callback function triggered when the tree node is clicked.
 * @param onRemoveClick A callback function triggered when the remove button is clicked in edit mode.
 * @param onMoveClick A callback function triggered when the move button is clicked in edit mode.
 *                    It receives the movedNode and newParentNode as parameters.
 *                    Pass null for newParentNode initially when moving to the root.
 * @param isEditMode A boolean indicating whether the TreeNodeItem is in edit mode.
 */
@Composable
fun TreeNodeItem(
    modifier: Modifier,
    treeNode: TreeNodeEntity,
    onItemClick: (TreeNodeEntity) -> Unit,
    onRemoveClick: (TreeNodeEntity) -> Unit,
    onMoveClick: (TreeNodeEntity, TreeNodeEntity?) -> Unit,
    isEditMode: Boolean
) {
    // Card for styling and elevation
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        // Box to make the entire Card clickable and provide background color
        Box(
            modifier = Modifier
                .clickable { onItemClick(treeNode) }
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
        ) {
            // Column to arrange content vertically
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                // Display the content of the TreeNode
                TreeNodeContent(treeNode = treeNode, onItemClick = onItemClick)

                // Recursively display children using LazyColumn
                treeNode.children?.let { children ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        children.forEach { childNode ->
                            // Recursive call to TreeNodeItem for each child node
                            TreeNodeItem(
                                modifier = Modifier,
                                treeNode = childNode,
                                onItemClick = onItemClick,
                                onRemoveClick = onRemoveClick,
                                onMoveClick = onMoveClick,
                                isEditMode = isEditMode
                            )
                        }
                    }
                }

                // Display edit actions when in edit mode
                if (isEditMode) {
                    TreeNodeEditActions(
                        onRemoveClick = { onRemoveClick(treeNode) },
                        onMoveClick = { onMoveClick(treeNode, null) } // Pass null for newParentNode initially
                    )
                }
            }
        }
    }
}





package com.marzbani.presentation.nodes

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.marzbani.presentation.nodes.component.MainAppBar
import com.marzbani.presentation.nodes.component.TreeNodeItem


@Composable
fun NodesScreen(
    modifier: Modifier,
    viewModel: NodesViewModel,
    navController: NavHostController
) {
    // Collect the data as a Compose state
    val data by viewModel.nodesData.collectAsState()

    // Scaffold for the overall structure
    Scaffold(
        topBar = {
            // MainAppBar for the top bar, with edit mode toggle
            MainAppBar(
                onEditClick = { viewModel.toggleEditMode() },
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    ) { paddingValues ->
        // LazyColumn for efficiently displaying a list of items
        LazyColumn(
            modifier = modifier.padding(paddingValues),
            content = {
                // Iterate over the data to create TreeNodeItem for each node
                items(data) { treeNode ->
                    // TreeNodeItem to display a tree node
                    TreeNodeItem(
                        modifier = modifier,
                        treeNode = treeNode,
                        onItemClick = { viewModel.onItemClick(it, navController) },
                        onRemoveClick = { viewModel.onRemoveClick(it) },
                        onMoveClick = { movedNode, parentNode -> viewModel.onMoveClick(movedNode, parentNode) },
                        isEditMode = viewModel.isEditMode
                    )
                }
            }
        )
    }
}




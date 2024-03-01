package com.marzbani.presentation.nodes

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.usecase.GetNodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NodesViewModel @Inject constructor(private val getNodesUseCase: GetNodesUseCase) : ViewModel() {

    // StateFlow to observe changes in the list of tree nodes
    private val _nodesData = MutableStateFlow<List<TreeNodeEntity>>(emptyList())
    val nodesData: StateFlow<List<TreeNodeEntity>> get() = _nodesData

    // State to track whether the view is in edit mode
    private var _isEditMode by mutableStateOf(false)
    val isEditMode: Boolean get() = _isEditMode

    // Function to toggle the edit mode
    fun toggleEditMode() {
        _isEditMode = !_isEditMode
    }

    // Initial loading of data when the ViewModel is created
    init {
        loadData()
    }

    // Function to handle the loading of data
    private fun loadData() {
        getNodesUseCase.execute(
            params = "data.json",
            onSuccess = {
                _nodesData.value = it
            },
            onError = { error ->
                // Handle errors during data loading
                handleDataLoadError(error)
            }
        )
    }

    // Function to handle errors during data loading
    private fun handleDataLoadError(error: Throwable) {
        // show an error message to the user
        Log.e("NodesViewModel", "Error loading data: ${error.message}", error)
    }

    // Function triggered when a tree node needs to be removed
    fun onRemoveClick(selectedNode: TreeNodeEntity) {
        _nodesData.value = removeNodeRecursively(_nodesData.value, selectedNode)
    }

    // Recursive function to remove a tree node and its children
    private fun removeNodeRecursively(nodes: List<TreeNodeEntity>, targetNode: TreeNodeEntity): List<TreeNodeEntity> {
        return nodes.filterNot { it == targetNode }
            .map { it.copy(children = removeNodeRecursively(it.children.orEmpty(), targetNode)) }
    }

    // Function triggered when a tree node is clicked, navigating to a details screen
    fun onItemClick(selectedNode: TreeNodeEntity, navController: NavController) {
        Log.e("selectedNode", selectedNode.id.toString())
        navController.navigate("details/${selectedNode.id}")
    }

    // Function triggered when a tree node needs to be moved
    fun onMoveClick(movedNode: TreeNodeEntity, newParentNode: TreeNodeEntity?) {
        // Logging details before and after moving a node
        Log.d("NodesViewModel", "Before Move:")
        Log.d("NodesViewModel", "Moved Node: $movedNode")
        Log.d("NodesViewModel", "New Parent Node: $newParentNode")
        Log.d("NodesViewModel", "Original Nodes: ${_nodesData.value}")

        // Move the node and update the StateFlow
        val updatedNodes = moveNode(_nodesData.value, movedNode, newParentNode)

        // Logging details after moving a node
        Log.d("NodesViewModel", "After Move:")
        Log.d("NodesViewModel", "Updated Nodes: $updatedNodes")

        // Update the StateFlow with the new node arrangement
        _nodesData.value = updatedNodes
    }

    // Recursive function to move a tree node within the hierarchy
    private fun moveNode(nodes: List<TreeNodeEntity>, movedNode: TreeNodeEntity, newParentNode: TreeNodeEntity?): List<TreeNodeEntity> {
        return nodes.map { node ->
            when (node) {
                movedNode -> {
                    node.copy(children = moveNode(node.children.orEmpty(), movedNode, null))
                }
                newParentNode -> {
                    node.copy(children = node.children.orEmpty() + movedNode)
                }
                else -> {
                    node.copy(children = moveNode(node.children.orEmpty(), movedNode, newParentNode))
                }
            }
        }.filterNot { it == movedNode }
    }



}

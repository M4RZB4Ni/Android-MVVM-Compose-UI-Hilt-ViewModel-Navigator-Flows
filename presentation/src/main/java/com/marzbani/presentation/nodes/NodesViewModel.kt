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


}

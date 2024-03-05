// TreeNodeModel.kt
package com.marzbani.data.model

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the model for tree nodes.
 *
 * @property label The label or name associated with the tree node.
 * @property id The unique identifier for the tree node (nullable).
 * @property children The list of child tree nodes, if any (nullable).
 */
data class TreeNodeModel(
    val label: String,
    val id: String?,
    @SerializedName("children")
    val children: List<TreeNodeModel>?
)

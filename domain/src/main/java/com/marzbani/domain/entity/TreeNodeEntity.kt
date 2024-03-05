// TreeNodeEntity.kt
package com.marzbani.domain.entity

/**
 * Represents a tree node entity in the application.
 *
 * @property label The label or name associated with the tree node.
 * @property id The unique identifier for the tree node.
 * @property children A list of child tree nodes, if any.
 */
data class TreeNodeEntity(
    val label: String,
    val id: String?,
    val children: List<TreeNodeEntity>?
)

// DetailsModel.kt
package com.marzbani.data.model

/**
 * Data class representing the model for details.
 *
 * @property id The unique identifier for details.
 * @property createdAt The timestamp indicating when the details were created.
 * @property createdBy The creator of the details.
 * @property lastModifiedAt The timestamp indicating the last modification of the details.
 * @property lastModifiedBy The user who last modified the details.
 * @property description The description associated with the details.
 */
data class DetailsModel(
    val id: String,
    val createdAt: String,
    val createdBy: String,
    val lastModifiedAt: String,
    val lastModifiedBy: String,
    val description: String
)

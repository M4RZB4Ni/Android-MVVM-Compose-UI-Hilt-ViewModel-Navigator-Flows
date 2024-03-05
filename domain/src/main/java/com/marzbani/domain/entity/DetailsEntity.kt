// DetailsEntity.kt
package com.marzbani.domain.entity

/**
 * Represents details information associated with a specific data entity.
 *
 * @property id The unique identifier for the details entity.
 * @property createdAt The timestamp indicating when the details entity was created.
 * @property createdBy The identifier of the user who created the details entity.
 * @property lastModifiedAt The timestamp indicating when the details entity was last modified.
 * @property lastModifiedBy The identifier of the user who last modified the details entity.
 * @property description Additional description or information about the details entity.
 * @constructor Creates a new instance of [DetailsEntity] with default values.
 */
data class DetailsEntity(
    val id: String,
    val createdAt: String,
    val createdBy: String,
    val lastModifiedAt: String,
    val lastModifiedBy: String,
    val description: String
) {
    /**
     * Secondary constructor with default values, providing an empty instance of [DetailsEntity].
     */
    constructor() : this("", "", "", "", "", "")
}

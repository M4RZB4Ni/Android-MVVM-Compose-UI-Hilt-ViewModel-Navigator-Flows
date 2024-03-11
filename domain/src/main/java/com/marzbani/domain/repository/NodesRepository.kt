// NodesRepository.kt
package com.marzbani.domain.repository

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for managing node-related data.
 */
interface NodesRepository {

    /**
     * Retrieves a list of tree nodes based on the provided URL.
     *
     * @param url The URL to fetch tree nodes from.
     * @return A Single emitting a list of [TreeNodeEntity] representing the tree nodes.
     */
    suspend fun getNodes(url: String): Flow<List<TreeNodeEntity>>

    /**
     * Retrieves additional data for a specific data code.
     *
     * @param dataCode The code associated with the data for which additional information is requested.
     * @return A Single emitting a [DetailsEntity] containing additional details.
     */
    suspend fun getAdditionalData(dataCode: String): Flow<DetailsEntity>
}

// NodesRepository.kt
package com.marzbani.domain.repository

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import io.reactivex.Single

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
    fun getNodes(url: String): Single<List<TreeNodeEntity>>

    /**
     * Retrieves additional data for a specific data code.
     *
     * @param dataCode The code associated with the data for which additional information is requested.
     * @return A Single emitting a [DetailsEntity] containing additional details.
     */
    fun getAdditionalData(dataCode: String): Single<DetailsEntity>
}

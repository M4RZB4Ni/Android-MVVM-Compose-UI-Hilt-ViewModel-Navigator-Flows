// NodesRepositoryImpl.kt
package com.marzbani.data.repository

import com.marzbani.data.mapper.DetailsEntityMapper
import com.marzbani.data.mapper.TreeNodeEntityMapper
import com.marzbani.data.source.NodesService
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import io.reactivex.Single

/**
 * Implementation of the [NodesRepository] interface for handling node-related data.
 *
 * @property service The [NodesService] instance for making network requests.
 * @property nodeMap The [TreeNodeEntityMapper] instance for mapping between entities and models.
 * @property detailsEntityMapper The [DetailsEntityMapper] instance for mapping between details entities and models.
 */
class NodesRepositoryImpl(
    private val service: NodesService,
    private val nodeMap: TreeNodeEntityMapper,
    private val detailsEntityMapper: DetailsEntityMapper
) : NodesRepository {

    /**
     * Retrieves a list of tree nodes based on the provided URL.
     *
     * @param url The URL for retrieving tree nodes.
     * @return A [Single] emitting the list of [TreeNodeEntity] objects.
     */
    override fun getNodes(url: String): Single<List<TreeNodeEntity>> {
        return service.getNodes(url)
            .map { nodeMap.toEntityList(it) }
    }

    /**
     * Retrieves additional data for a specific data code.
     *
     * @param dataCode The data code for retrieving additional data.
     * @return A [Single] emitting the [DetailsEntity] object.
     */
    override fun getAdditionalData(dataCode: String): Single<DetailsEntity> {
        return service.getAdditionalData(dataCode)
            .map { detailsEntityMapper.toEntity(it) }
    }
}

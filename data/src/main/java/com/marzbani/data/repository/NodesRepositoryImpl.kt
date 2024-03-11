// NodesRepositoryImpl.kt
package com.marzbani.data.repository

import com.marzbani.data.mapper.DetailsEntityMapper
import com.marzbani.data.mapper.TreeNodeEntityMapper
import com.marzbani.data.source.NodesService
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

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
    override suspend fun getNodes(url: String): Flow<List<TreeNodeEntity>> {
        return try {
            service.getNodes(url)
                .map { nodeMap.toEntityList(it) }
        }catch (e: Exception){
            flowOf(emptyList())
        }
    }

    /**
     * Retrieves additional data for a specific data code.
     *
     * @param dataCode The data code for retrieving additional data.
     * @return A [Single] emitting the [DetailsEntity] object.
     */
    override suspend fun getAdditionalData(dataCode: String): Flow<DetailsEntity> {
        return try {

            service.getAdditionalData(dataCode)
                .map { detailsEntityMapper.toEntity(it) }
        }catch (e:Exception){
            flowOf(DetailsEntity())
        }
    }
}

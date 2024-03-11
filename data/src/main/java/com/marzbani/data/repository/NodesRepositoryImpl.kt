// NodesRepositoryImpl.kt
package com.marzbani.data.repository

import com.marzbani.data.mapper.DetailsEntityMapper
import com.marzbani.data.mapper.TreeNodeEntityMapper
import com.marzbani.data.source.NodesService
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
    override fun getNodes(url: String): Flow<List<TreeNodeEntity>> = flow {
        try {

            service.getNodes(url).apply {
                emit(nodeMap.toEntityList(this))
            }
        }catch (e: Exception)
        {
            emit(emptyList())
        }
    }




    /**
     * Retrieves additional data for a specific data code.
     *
     * @param dataCode The data code for retrieving additional data.
     * @return A [Flow] emitting the [DetailsEntity] object.
     */
    override fun getAdditionalData(dataCode: String): Flow<DetailsEntity> = flow {
        try {
            service.getAdditionalData(dataCode)
                .apply { emit(detailsEntityMapper.toEntity(this)) }
        }catch (e: Exception)
        {
            emit(DetailsEntity())
        }

    }
}

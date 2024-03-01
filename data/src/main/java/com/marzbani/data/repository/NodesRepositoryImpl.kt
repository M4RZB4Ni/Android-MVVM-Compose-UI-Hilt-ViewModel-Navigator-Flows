package com.marzbani.data.repository

import com.marzbani.data.mapper.DetailsEntityMapper
import com.marzbani.data.mapper.TreeNodeEntityMapper
import com.marzbani.data.source.NodesService
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import io.reactivex.Single

// Implementation of the NodesRepository interface for handling node-related data.
class NodesRepositoryImpl(
    private val service: NodesService,
    private val nodeMap: TreeNodeEntityMapper,
    private val detailsEntityMapper: DetailsEntityMapper
) : NodesRepository {

    // Retrieves a list of tree nodes based on the provided URL.
    override fun getNodes(url: String): Single<List<TreeNodeEntity>> {
        return service.getNodes(url)
            .map { nodeMap.toEntityList(it) }
    }

    // Retrieves additional data for a specific data code.
    override fun getAdditionalData(dataCode: String): Single<DetailsEntity> {
        return service.getAdditionalData(dataCode)
            .map { detailsEntityMapper.toEntity(it) }
    }
}

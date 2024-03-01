package com.marzbani.domain.repository

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import io.reactivex.Single

// Repository interface for managing node-related data.
interface NodesRepository {

    // Retrieves a list of tree nodes based on the provided URL.
    fun getNodes(url: String): Single<List<TreeNodeEntity>>

    // Retrieves additional data for a specific data code.
    fun getAdditionalData(dataCode: String): Single<DetailsEntity>
}

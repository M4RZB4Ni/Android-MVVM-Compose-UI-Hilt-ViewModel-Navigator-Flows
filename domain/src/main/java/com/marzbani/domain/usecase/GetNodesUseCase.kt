package com.marzbani.domain.usecase

import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case responsible for retrieving a list of tree nodes based on a given URL.
 *
 * @param repository Repository providing data access methods.
 */
class GetNodesUseCase @Inject constructor(private val repository: NodesRepository) {
   operator fun invoke(params:String) : Flow<List<TreeNodeEntity>> = repository.getNodes(params)
}

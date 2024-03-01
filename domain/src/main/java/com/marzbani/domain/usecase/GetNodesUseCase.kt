package com.marzbani.domain.usecase

import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import com.marzbani.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Use case responsible for retrieving a list of tree nodes based on a given URL.
 *
 * @param repository Repository providing data access methods.
 */
class GetNodesUseCase @Inject constructor(private val repository: NodesRepository) :
    SingleUseCase<String, List<TreeNodeEntity>>() {

    /**
     * Build the Single use case to get a list of tree nodes for the provided URL.
     *
     * @param params URL for which tree nodes are to be retrieved.
     * @return Single representing the asynchronous operation.
     */
    override fun buildUseCaseSingle(params: String): Single<List<TreeNodeEntity>> {
        return repository.getNodes(params)
    }
}

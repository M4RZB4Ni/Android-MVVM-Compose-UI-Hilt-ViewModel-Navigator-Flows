package com.marzbani.domain.usecase

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.repository.NodesRepository
import com.marzbani.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Use case responsible for retrieving details information based on a given data code.
 *
 * @param repository Repository providing data access methods.
 */
class GetDetailsUseCase @Inject constructor(private val repository: NodesRepository) :
    SingleUseCase<String, DetailsEntity>() {

    /**
     * Build the Single use case to get details information for the provided data code.
     *
     * @param params Data code for which details information is to be retrieved.
     * @return Single representing the asynchronous operation.
     */
    override fun buildUseCaseSingle(params: String): Single<DetailsEntity> {
        return repository.getAdditionalData(params)
    }
}

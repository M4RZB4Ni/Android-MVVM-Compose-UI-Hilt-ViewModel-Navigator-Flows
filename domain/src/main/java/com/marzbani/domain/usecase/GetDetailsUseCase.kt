package com.marzbani.domain.usecase

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.repository.NodesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case responsible for retrieving details information based on a given data code.
 *
 * @param repository Repository providing data access methods.
 */
class GetDetailsUseCase @Inject constructor(
    private val repository: NodesRepository,
)  {
    operator fun invoke(params: String) : Flow<DetailsEntity> = repository.getAdditionalData(params)

}

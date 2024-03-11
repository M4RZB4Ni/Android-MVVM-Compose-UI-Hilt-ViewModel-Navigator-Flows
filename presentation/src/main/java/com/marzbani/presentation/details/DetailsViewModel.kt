package com.marzbani.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.usecase.GetDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel class for the details screen.
 *
 * @param detailsUseCase The use case for fetching details data.
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsUseCase: GetDetailsUseCase) : ViewModel() {

    // MutableStateFlow to hold the details data as a state
    private val _details = MutableStateFlow(DetailsEntity())

    // Exposed StateFlow to observe details data changes
    val details: StateFlow<DetailsEntity> get() = _details

    /**
     * Function to fetch details data based on the provided nodeId.
     *
     * @param nodeId The id of the node to fetch details for.
     */
    fun getDetails(nodeId: String) {
        viewModelScope.launch {
            detailsUseCase.invoke(nodeId).collect{
                _details.value = it
            }
        }
    }

}

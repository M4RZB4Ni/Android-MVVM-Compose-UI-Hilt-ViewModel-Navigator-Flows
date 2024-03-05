package com.marzbani.presentation.details

import android.util.Log
import androidx.lifecycle.ViewModel
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.usecase.GetDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
        detailsUseCase.execute(
            params = nodeId,
            onSuccess = {
                // Update the MutableStateFlow with the fetched details data
                _details.value = it
            },
            onError = { error ->
                // Handle error by printing the stack trace
                handleDataLoadError(error)
            }
        )
    }

    /**
     * Function to handle errors during data loading.
     *
     * @param error The Throwable object representing the error.
     */
    private fun handleDataLoadError(error: Throwable) {
        // Show an error message to the user and log the error
        Log.e("DetailsViewModel", "Error loading data: ${error.message}", error)
    }
}

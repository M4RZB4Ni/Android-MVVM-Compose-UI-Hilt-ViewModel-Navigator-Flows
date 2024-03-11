// NodesService.kt
package com.marzbani.data.source

import com.marzbani.data.model.DetailsModel
import com.marzbani.data.model.TreeNodeModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 * Retrofit service interface for fetching node-related data.
 */
interface NodesService {

    /**
     * Fetches nodes based on the provided URL.
     *
     * @param url The URL for retrieving tree nodes.
     * @return A [Flow] emitting the list of [TreeNodeModel] objects.
     */
    @GET
    suspend fun getNodes(@Url url: String): List<TreeNodeModel>

    /**
     * Fetches additional data for a specific data code.
     *
     * @param imageCode The data code for retrieving additional data.
     * @return A [Flow] emitting the [DetailsModel] object.
     */
    @GET("entries/{dataCode}.json")
    suspend fun getAdditionalData(@Path("dataCode") imageCode: String): DetailsModel
}

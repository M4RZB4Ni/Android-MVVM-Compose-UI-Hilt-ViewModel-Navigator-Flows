package com.marzbani.data.source

import com.marzbani.data.model.DetailsModel
import com.marzbani.data.model.TreeNodeModel
import com.marzbani.domain.entity.TreeNodeEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

// Retrofit service interface for fetching node-related data.
interface NodesService {

    // Fetches nodes based on the provided URL.
    @GET
    fun getNodes(@Url url: String): Single<List<TreeNodeModel>>

    // Fetches additional data for a specific data code.
    @GET("entries/{dataCode}.json")
    fun getAdditionalData(@Path("dataCode") imageCode: String): Single<DetailsModel>
}

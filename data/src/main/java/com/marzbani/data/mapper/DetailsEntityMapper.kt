// DetailsEntityMapper.kt
package com.marzbani.data.mapper

import com.google.gson.Gson
import com.marzbani.data.model.DetailsModel
import com.marzbani.domain.entity.DetailsEntity

/**
 * Mapper class for converting [DetailsEntity] to [DetailsModel] and vice versa.
 */
class DetailsEntityMapper {

    // Gson instance for JSON conversion.
    private val gson = Gson()

    /**
     * Converts [DetailsEntity] to [DetailsModel].
     *
     * @param entity DetailsEntity to be converted.
     * @return Converted DetailsModel.
     */
    fun fromEntity(entity: DetailsEntity): DetailsModel {
        val json = gson.toJson(entity)
        return gson.fromJson(json, DetailsModel::class.java)
    }

    /**
     * Converts [DetailsModel] to [DetailsEntity].
     *
     * @param model DetailsModel to be converted.
     * @return Converted DetailsEntity.
     */
    fun toEntity(model: DetailsModel): DetailsEntity {
        val json = gson.toJson(model)
        return gson.fromJson(json, DetailsEntity::class.java)
    }
}

// TreeNodeEntityMapper.kt
package com.marzbani.data.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marzbani.data.model.TreeNodeModel
import com.marzbani.domain.entity.TreeNodeEntity

/**
 * Mapper class responsible for converting between [TreeNodeEntity] and [TreeNodeModel].
 */
class TreeNodeEntityMapper {

    // Gson instance for JSON conversion.
    private val gson = Gson()

    /**
     * Converts a list of [TreeNodeEntity] to a list of [TreeNodeModel].
     *
     * @param entities List of [TreeNodeEntity] to be converted.
     * @return List of [TreeNodeModel] resulting from the conversion.
     */
    fun fromEntityList(entities: List<TreeNodeEntity>): List<TreeNodeModel> {
        val json = gson.toJson(entities)
        val listType = object : TypeToken<List<TreeNodeModel>>() {}.type
        return gson.fromJson(json, listType)
    }

    /**
     * Converts a list of [TreeNodeModel] to a list of [TreeNodeEntity].
     *
     * @param models List of [TreeNodeModel] to be converted.
     * @return List of [TreeNodeEntity] resulting from the conversion.
     */
    fun toEntityList(models: List<TreeNodeModel>): List<TreeNodeEntity> {
        val json = gson.toJson(models)
        val listType = object : TypeToken<List<TreeNodeEntity>>() {}.type
        return gson.fromJson(json, listType)
    }
}

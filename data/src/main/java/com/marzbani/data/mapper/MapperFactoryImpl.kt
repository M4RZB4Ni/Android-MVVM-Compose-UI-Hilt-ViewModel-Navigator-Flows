// MapperFactoryImpl.kt
package com.marzbani.data.mapper

import com.marzbani.data.di.MapperFactory

/**
 * Implementation of the [MapperFactory] interface providing instances of mappers.
 */
class MapperFactoryImpl : MapperFactory {

    /**
     * Provides an instance of [TreeNodeEntityMapper].
     *
     * @return Instance of TreeNodeEntityMapper.
     */
    override fun provideTreeNodeEntityMapper(): TreeNodeEntityMapper {
        return TreeNodeEntityMapper()
    }

    /**
     * Provides an instance of [DetailsEntityMapper].
     *
     * @return Instance of DetailsEntityMapper.
     */
    override fun provideDetailsEntityMapper(): DetailsEntityMapper {
        return DetailsEntityMapper()
    }
}

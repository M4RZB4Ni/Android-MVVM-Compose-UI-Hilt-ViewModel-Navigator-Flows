package com.marzbani.data.di

import com.marzbani.data.mapper.DetailsEntityMapper
import com.marzbani.data.mapper.TreeNodeEntityMapper

// Interface defining the abstraction for obtaining mappers.
interface MapperFactory {
    // Provides an instance of TreeNodeEntityMapper.
    fun provideTreeNodeEntityMapper(): TreeNodeEntityMapper

    // Provides an instance of DetailsEntityMapper.
    fun provideDetailsEntityMapper(): DetailsEntityMapper
}

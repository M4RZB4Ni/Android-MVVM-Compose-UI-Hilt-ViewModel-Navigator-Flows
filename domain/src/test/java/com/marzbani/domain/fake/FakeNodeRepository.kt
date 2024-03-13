package com.marzbani.domain.fake

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeNodeRepository : NodesRepository {

    private val nodesList: Flow<List<TreeNodeEntity>> by lazy {
        val nodeThree = TreeNodeEntity("Node three", "", emptyList())
        val nodeTwo = TreeNodeEntity("Node two", "", listOf(nodeThree))
        val nodeOne = TreeNodeEntity("Node one", "", listOf(nodeTwo))

        flowOf((listOf(nodeOne)))
    }

    private val nodeItem:Flow<DetailsEntity> = flowOf(DetailsEntity("1","First January","First January","First January","First January","Description"))
    override fun getNodes(url: String): Flow<List<TreeNodeEntity>> {
        println("getNodes called with url: $url")
        return nodesList
    }

    override fun getAdditionalData(dataCode: String): Flow<DetailsEntity> {
        println("getAdditionalData called with dataCode: $dataCode")
        return nodeItem
    }
}
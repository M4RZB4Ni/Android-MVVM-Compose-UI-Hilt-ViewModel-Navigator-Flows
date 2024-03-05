package com.marzbani.domain.fake

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.repository.NodesRepository
import io.reactivex.Single

class FakeNodeRepository : NodesRepository {

    private val nodesList : Single<List<TreeNodeEntity>> = Single.just(listOf(TreeNodeEntity("Node one","",
        listOf(TreeNodeEntity("Node two","",
            listOf(TreeNodeEntity("Node three","",
                listOf()
            ))
        ))
    )))
    private val nodeItem:Single<DetailsEntity> = Single.just(DetailsEntity("1","First January","First January","First January","First January","Description"))
    override fun getNodes(url: String): Single<List<TreeNodeEntity>> {
        return nodesList
    }

    override fun getAdditionalData(dataCode: String): Single<DetailsEntity> {
        return nodeItem
    }
}
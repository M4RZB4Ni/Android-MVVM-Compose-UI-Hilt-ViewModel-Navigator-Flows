package com.marzbani.domain

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.entity.TreeNodeEntity
import com.marzbani.domain.fake.FakeNodeRepository
import com.marzbani.domain.usecase.GetDetailsUseCase
import com.marzbani.domain.usecase.GetNodesUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class GetDetailsUseCaseTest {

    private lateinit var detailsUseCase: GetDetailsUseCase
    private lateinit var nodesUseCase: GetNodesUseCase
    private lateinit var fakeNodeRepository: FakeNodeRepository
    private val detailsItem: DetailsEntity = DetailsEntity("1","First January","First January","First January","First January","Description")

    private val nodesList: Flow<List<TreeNodeEntity>> by lazy {
        val nodeThree = TreeNodeEntity("Node three", "", emptyList())
        val nodeTwo = TreeNodeEntity("Node two", "", listOf(nodeThree))
        val nodeOne = TreeNodeEntity("Node one", "", listOf(nodeTwo))

        flowOf((listOf(nodeOne)))
    }



    @Before
    fun setUp() {
        fakeNodeRepository = FakeNodeRepository()
        detailsUseCase = GetDetailsUseCase(fakeNodeRepository)
        nodesUseCase = GetNodesUseCase(fakeNodeRepository)
    }



    @Test
    fun `Get Details of Node` (): Unit = runBlocking {
        val movies = detailsUseCase("data")
        assertEquals(detailsItem,movies.first())
    }

    @Test
    fun `Get Nodes` (): Unit = runBlocking {
        val nodes = nodesUseCase("data.json")
        assertEquals(nodesList.first(),nodes.first())
    }

    @After
    fun finish(){
    }




}
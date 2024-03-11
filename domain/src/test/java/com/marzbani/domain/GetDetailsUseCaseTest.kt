package com.marzbani.domain

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.fake.FakeNodeRepository
import com.marzbani.domain.usecase.GetDetailsUseCase
import org.junit.After
import org.junit.Before
import org.junit.Test


//@Config(manifest=Config.NONE)// Choose an appropriate version
//@RunWith(RobolectricTestRunner::class)
class GetDetailsUseCaseTest {

    private lateinit var detailsUseCase: GetDetailsUseCase
    private lateinit var fakeNodeRepository: FakeNodeRepository
    private val detailsItem: DetailsEntity = DetailsEntity("1","First January","First January","First January","First January","Description")
//    private var detailsUseCase = mock(GetDetailsUseCase::class.java)
//    private var fakeNodeRepository = mock(NodesRepository::class.java)


    @Before
    fun setUp() {
        fakeNodeRepository = FakeNodeRepository()
        detailsUseCase = GetDetailsUseCase(fakeNodeRepository)
    }



    @Test
    fun getAdditionalData() {




    }
    @After
    fun finish(){

    }

//    @Test
//    fun `Get Movie Details, correct movie id return` (): Unit = runBlocking{
//        val movieDetails =  detailsUseCase.buildUseCaseSingle("Param data").test()
//        movieDetails.
//    }


}
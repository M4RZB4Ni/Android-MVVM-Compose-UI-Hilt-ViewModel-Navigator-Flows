package com.marzbani.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.fake.FakeNodeRepository
import com.marzbani.domain.usecase.GetDetailsUseCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest=Config.NONE)// Choose an appropriate version
@RunWith(RobolectricTestRunner::class)
class GetDetailsUseCaseTest {

    private lateinit var detailsUseCase: GetDetailsUseCase
    private val nodeItem: DetailsEntity = DetailsEntity("1","First January","First January","First January","First January","Description")

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
//        RxJavaPlugins.reset()
//        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }

        detailsUseCase = GetDetailsUseCase(FakeNodeRepository())
    }

    @After
    fun tearDown() {
//        RxJavaPlugins.reset()
    }

    @Test
    fun getAdditionalData() {
        val testObserver = detailsUseCase.buildUseCaseSingle("Param data").test()
        // Assert the result
        testObserver.assertComplete()
            .assertNoErrors()
            .assertValue { it == nodeItem }

        // Dispose of the test observer
        testObserver.dispose()
    }


}
package com.marzbani.domain.fake

import com.marzbani.domain.entity.DetailsEntity
import com.marzbani.domain.usecase.base.SingleUseCase
import io.reactivex.Single

class FakeGetDetailsUseCase : SingleUseCase<String, DetailsEntity>() {

    private val nodeItem:Single<DetailsEntity> = Single.just(DetailsEntity("1","First January","First January","First January","First January","Description"))

    override fun buildUseCaseSingle(params: String): Single<DetailsEntity> {
        return nodeItem
    }

}
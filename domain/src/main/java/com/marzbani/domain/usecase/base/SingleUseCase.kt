package com.marzbani.domain.usecase.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Base class for RxJava Single use cases providing common functionality for executing single asynchronous operations.
 *
 * @param Params Type of parameters required for the use case.
 * @param T Type of the result emitted by the Single.
 */
abstract class SingleUseCase<in Params, T> : UseCase() {

    /**
     * Build the Single use case with the given parameters.
     *
     * @param params Parameters required for the use case.
     * @return Single representing the asynchronous operation.
     */
    internal abstract fun buildUseCaseSingle(params: Params): Single<T>

    /**
     * Execute the Single use case with the given parameters.
     *
     * @param params Parameters required for the use case.
     * @param onSuccess Callback function to be called on successful execution with the result.
     * @param onError Callback function to be called on error during execution.
     * @param onFinished Callback function to be called after the execution, regardless of success or error.
     */
    fun execute(
        params: Params,
        onSuccess: ((t: T) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        // Dispose the last disposable if it exists and is not disposed.
        disposeLastDisposable()

        // Build the Single, subscribe on IO thread, observe on the main thread, and handle termination.
        lastDisposable = buildUseCaseSingle(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onFinished)
            .subscribe(onSuccess, onError)

        // Add the disposable to the composite disposable.
        lastDisposable.let {
            compositeDisposable.add(it)
        }
    }
}

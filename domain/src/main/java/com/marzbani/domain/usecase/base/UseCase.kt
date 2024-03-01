package com.marzbani.domain.usecase.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base class for RxJava use cases providing common functionality for managing disposables.
 */
abstract class UseCase {

    // Stores the last disposable used to allow for easy disposal.
    protected lateinit var lastDisposable: Disposable

    // Composite disposable to manage multiple disposables.
    protected val compositeDisposable = CompositeDisposable()

    /**
     * Dispose the last disposable if it exists and is not disposed.
     */
    fun disposeLastDisposable() {
        if (::lastDisposable.isInitialized && !lastDisposable.isDisposed) {
            lastDisposable.dispose()
        }
    }

    /**
     * Dispose all disposables in the composite disposable.
     */
    fun dispose() {
        compositeDisposable.clear()
    }
}

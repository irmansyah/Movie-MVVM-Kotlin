package com.irmansyah.catalogmoviekotlin.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N> constructor(var dataManager: DataManager, var schedulerProvider: SchedulerProvider) : ViewModel() {

    var navigator: N? = null
    val isLoading = ObservableBoolean(false)

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}